package br.ufsc.bridge.mpiclient.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import br.ufsc.bridge.mpiclient.exceptions.MPIException;
import br.ufsc.bridge.mpiclient.exceptions.MPIPixException;
import br.ufsc.bridge.mpiclient.exceptions.MPISoapException;
import br.ufsc.bridge.mpiclient.messages.MCCI_IN000002UV01;
import br.ufsc.bridge.mpiclient.messages.PRPA_IN201301UV02;
import br.ufsc.bridge.mpiclient.messages.PRPA_IN201305UV02;
import br.ufsc.bridge.mpiclient.messages.PRPA_IN201306UV02;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.soap.StringMessageBuilder;
import br.ufsc.bridge.soap.http.SoapCredential;
import br.ufsc.bridge.soap.http.SoapHttpRequest;
import br.ufsc.bridge.soap.http.SoapHttpResponse;
import br.ufsc.bridge.soap.xpath.XPathFactoryAssist;

public class MPIClient {

	private static BlockingQueue<Transformer> transformerPool = new LinkedBlockingQueue<>(5);

	static {
		TransformerFactory factory = TransformerFactory.newInstance();
		int poolSize = 5;
		try {
			for (int i = 0; i < poolSize; i++) {
				transformerPool.add(factory.newTransformer());
			}
		} catch (TransformerConfigurationException e) {
			throw new RuntimeException("Erro ao inicializar o pool de Transformer.", e);
		}
	}

	private MPIClientOptions options;

	public MPIClient(MPIClientOptions options) {
		this.options = options;
	}

	public void inserir(Cidadao cidadao) throws MPIException {
		try {
			String messageBody = new PRPA_IN201301UV02().create(cidadao, LocalDateTime.now());
			String documentToString = this.sendSoap(this.options.getPixUrl(), "urn:hl7-org:v3:PRPA_IN201301UV02", messageBody, "MCCI_IN000002UV01");
			PIXResponse response = new MCCI_IN000002UV01().read(new ByteArrayInputStream(documentToString.getBytes()));
			if (response.getErrorMessage() != null) {
				throw new MPIPixException(response.getErrorMessage());
			}
		} catch (SAXException | IOException e) {
			throw new MPISoapException(e);
		}
	}

	public List<Cidadao> consultar(PDQParameters parameters) throws MPIException {
		try {
			String messageBody = new PRPA_IN201305UV02().create(parameters, LocalDateTime.now());
			String documentToString = this.sendSoap(this.options.getPdqUrl(), "urn:hl7-org:v3:PRPA_IN201305UV02", messageBody, "PRPA_IN201306UV02");
			return new PRPA_IN201306UV02().read(new ByteArrayInputStream(documentToString.getBytes()));
		} catch (SAXException | IOException e) {
			throw new MPISoapException(e);
		}
	}

	private String sendSoap(String url, String action, String messageBody, String bodyContentTag)
			throws MPISoapException {
		try {
			StringMessageBuilder messageBuilder = new StringMessageBuilder(new SoapCredential(this.options.getUser(), this.options.getPassword()));
			SoapHttpRequest request = new SoapHttpRequest(url, action, messageBuilder.createMessage(messageBody));
			request.addHeader("Accept-Encoding", "gzip,deflate");
			SoapHttpResponse response = this.options.getClient().request(request);

			XPathFactoryAssist xPathAssist = new XPathFactoryAssist(response.getSoap()).getXPathAssist("Envelope");

			Node errorText = xPathAssist.getNode(".//Body//Reason//Text");

			if (errorText != null) {
				Node firstChild = errorText.getFirstChild();
				String textContent = firstChild.getTextContent();
				throw new MPISoapException(textContent);
			}

			Node contentNode = xPathAssist.getNode(".//" + bodyContentTag);

			if (contentNode == null) {
				contentNode = xPathAssist.getNode(".//Body//" + bodyContentTag);
			}

			return this.documentToString(contentNode);
		} catch (Exception e) {
			throw new MPISoapException(e);
		}
	}

	private String documentToString(Node doc) {
		Transformer transformer = null;
		try {
			StringWriter sw = new StringWriter();
			transformer = transformerPool.take();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "no");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			transformer.transform(new DOMSource(doc), new StreamResult(sw));
			return sw.toString().replace(" standalone=\"no\"", "");
		} catch (Exception ex) {
			throw new RuntimeException("Error converting to String", ex);
		} finally {
			if (transformer != null) {
				transformerPool.add(transformer);
			}
		}
	}
}
