package br.ufsc.bridge.mpiclient.soap;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import br.ufsc.bridge.soap.http.SoapCredential;
import br.ufsc.bridge.soap.http.SoapMessageBuilder;

public class StringMessageBuilder extends SoapMessageBuilder<String> {

	public StringMessageBuilder(SoapCredential c) {
		super(c);
	}

	@Override
	protected Document toDocument(String data) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(new InputSource(new StringReader(data)));
	}
}
