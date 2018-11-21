package br.ufsc.bridge.mpiclient.messages;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.ufsc.bridge.mpiclient.api.PIXResponse;
import br.ufsc.bridge.mpiclient.exceptions.MPIXmlParseException;
import br.ufsc.bridge.mpiclient.responsehandler.pix.PIXResponseMessageHandler;

/**
 * MCCI_IN000002UV01
 */
public class PIXResponseMessage {

	public PIXResponse read(InputStream xmlStream) throws MPIXmlParseException {
		try {
			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			xmlReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
			PIXResponseMessageHandler handler = new PIXResponseMessageHandler(xmlReader);
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(xmlStream));

			return handler.getPixResponse();
		} catch (SAXException | IOException e) {
			throw new MPIXmlParseException("Erro ao ler resposta.", e);
		}
	}

}
