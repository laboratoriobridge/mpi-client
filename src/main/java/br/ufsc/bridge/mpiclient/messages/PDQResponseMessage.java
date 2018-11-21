package br.ufsc.bridge.mpiclient.messages;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.XMLConstants;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.ufsc.bridge.mpiclient.exceptions.MPIXmlParseException;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.responsehandler.pdq.PDQResponseMessageHandler;

/**
 * PRPA_IN201306UV02
 */
public class PDQResponseMessage {

	public List<Cidadao> read(InputStream xmlStream) throws MPIXmlParseException {
		try {
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			xmlReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			PDQResponseMessageHandler handler = new PDQResponseMessageHandler(xmlReader);
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(xmlStream));

			return handler.getCidadaos();
		} catch (SAXException | IOException e) {
			throw new MPIXmlParseException("Erro ao ler resposta.", e);
		}
	}

}
