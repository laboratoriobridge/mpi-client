package br.ufsc.bridge.mpiclient.messages;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.responsehandler.pdq.PRPA_IN201306UV02Handler;

public class PRPA_IN201306UV02 {

	public List<Cidadao> read(InputStream xmlStream) throws SAXException, IOException {
		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		PRPA_IN201306UV02Handler handler = new PRPA_IN201306UV02Handler(xmlReader);
		xmlReader.setContentHandler(handler);
		xmlReader.parse(new InputSource(xmlStream));

		return handler.getCidadaos();
	}

}
