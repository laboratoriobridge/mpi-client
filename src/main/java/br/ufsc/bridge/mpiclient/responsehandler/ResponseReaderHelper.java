package br.ufsc.bridge.mpiclient.responsehandler;

import javax.xml.XMLConstants;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class ResponseReaderHelper {

	private ResponseReaderHelper() {
		// empty private constructor
	}

	public static XMLReader createXmlReader() throws SAXException {
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		xmlReader.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		xmlReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		return xmlReader;
	}

}
