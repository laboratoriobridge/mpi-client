package br.ufsc.bridge.mpiclient.messages;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.ufsc.bridge.mpiclient.api.PIXResponse;
import br.ufsc.bridge.mpiclient.responsehandler.pix.MCCI_IN000002UV01Handler;

public class MCCI_IN000002UV01 {

	public PIXResponse read(InputStream xmlStream) throws SAXException, IOException {
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		MCCI_IN000002UV01Handler handler = new MCCI_IN000002UV01Handler(xmlReader);
		xmlReader.setContentHandler(handler);
		xmlReader.parse(new InputSource(xmlStream));

		return handler.getPixResponse();
	}

}
