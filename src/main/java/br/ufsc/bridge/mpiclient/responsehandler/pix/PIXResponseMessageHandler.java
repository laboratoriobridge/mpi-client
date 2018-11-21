package br.ufsc.bridge.mpiclient.responsehandler.pix;

import lombok.Getter;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import br.ufsc.bridge.mpiclient.api.PIXResponse;

public class PIXResponseMessageHandler extends DefaultHandler {

	@Getter
	private PIXResponse pixResponse = new PIXResponse();
	private final AcknowledgementDetailHandler detailHandler;
	private XMLReader reader;

	public PIXResponseMessageHandler(XMLReader reader) {
		this.reader = reader;
		this.detailHandler = new AcknowledgementDetailHandler();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if ("acknowledgementDetail".equals(localName)) {
			this.detailHandler.handle(this.reader, this, this.pixResponse, attributes);
		}
	}

}
