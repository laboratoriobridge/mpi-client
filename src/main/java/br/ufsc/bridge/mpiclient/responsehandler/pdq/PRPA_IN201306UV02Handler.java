package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import br.ufsc.bridge.mpiclient.model.Cidadao;

public class PRPA_IN201306UV02Handler extends DefaultHandler {

	@Getter
	private List<Cidadao> cidadaos = new ArrayList<>();
	private Cidadao current;
	private XMLReader reader;
	private final PatientHandler patientHandler;

	public PRPA_IN201306UV02Handler(XMLReader reader) {
		this.reader = reader;
		this.patientHandler = new PatientHandler();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if ("subject".equals(localName)) {
			this.current = new Cidadao();
		} else if (this.patientHandler.accept(localName, attributes)) {
			this.patientHandler.handle(this.reader, this, this.current, attributes);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if ("subject".equals(localName)) {
			this.cidadaos.add(this.current);
			this.current = null;
		}
	}
}
