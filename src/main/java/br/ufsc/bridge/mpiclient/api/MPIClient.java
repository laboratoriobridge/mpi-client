package br.ufsc.bridge.mpiclient.api;

import java.io.ByteArrayInputStream;
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

import org.apache.commons.io.Charsets;
import org.w3c.dom.Node;

import br.ufsc.bridge.mpiclient.exceptions.MPIException;
import br.ufsc.bridge.mpiclient.exceptions.MPIPixException;
import br.ufsc.bridge.mpiclient.exceptions.MPIRuntimeException;
import br.ufsc.bridge.mpiclient.exceptions.MPISoapException;
import br.ufsc.bridge.mpiclient.messages.PDQRequestMessage;
import br.ufsc.bridge.mpiclient.messages.PDQResponseMessage;
import br.ufsc.bridge.mpiclient.messages.PIXRequestMessage;
import br.ufsc.bridge.mpiclient.messages.PIXResponseMessage;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.soap.http.SoapCredential;
import br.ufsc.bridge.soap.http.SoapHttpRequest;
import br.ufsc.bridge.soap.http.SoapHttpResponse;
import br.ufsc.bridge.soap.string.StringMessageBuilder;
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
			throw new MPIRuntimeException("Erro ao inicializar o pool de Transformer.", e);
		}
	}

	private MPIClientOptions options;

	public MPIClient(MPIClientOptions options) {
		this.options = options;
	}

	public void inserir(Cidadao cidadao) throws MPIException {
		String messageBody = new PIXRequestMessage().create(cidadao, LocalDateTime.now());
		String documentToString = this.sendSoap(this.options.getPixUrl(), "urn:hl7-org:v3:PIXRequestMessage", messageBody, "PIXResponseMessage");
		PIXResponse response = new PIXResponseMessage().read(new ByteArrayInputStream(documentToString.getBytes(Charsets.UTF_8)));
		if (response.getErrorMessage() != null) {
			throw new MPIPixException(response.getErrorMessage());
		}
	}

	public List<Cidadao> consultar(PDQParameters parameters) throws MPIException {
		String messageBody = new PDQRequestMessage().create(parameters, LocalDateTime.now());
		String documentToString = this.sendSoap(this.options.getPdqUrl(), "urn:hl7-org:v3:PDQRequestMessage", messageBody, "PDQResponseMessage");
		return new PDQResponseMessage().read(new ByteArrayInputStream(documentToString.getBytes(Charsets.UTF_8)));
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

	private String documentToString(Node doc) throws MPISoapException {
		Transformer transformer = null;
		try (StringWriter sw = new StringWriter()) {
			transformer = transformerPool.take();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "no");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			transformer.transform(new DOMSource(doc), new StreamResult(sw));
			return sw.toString().replace(" standalone=\"no\"", "");
		} catch (Exception ex) {
			throw new MPISoapException("Error converting to String", ex);
		} finally {
			if (transformer != null) {
				transformerPool.add(transformer);
			}
		}
	}
}
