package br.ufsc.bridge.mpiclient.responsehandler;

import java.io.CharArrayWriter;
import java.util.function.Consumer;

import org.xml.sax.SAXException;

public class XmlTextHandler extends DefaultAttributeHandler {

	private CharArrayWriter contents = new CharArrayWriter();
	private Consumer<String> textConsumer;

	public XmlTextHandler(String tag, Consumer<String> textConsumer) {
		super(tag);
		this.textConsumer = textConsumer;
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		this.contents.write(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (this.tag.equals(localName)) {
			this.textConsumer.accept(this.contents.toString());
			this.contents.reset();
		}
		super.endElement(uri, localName, qName);
	}

}
