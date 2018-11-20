package br.ufsc.bridge.mpiclient.responsehandler;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public abstract class DefaultAttributeHandler<T> extends DefaultHandler implements AttributeHandler<T> {

	@Getter
	protected T current;
	protected List<AttributeHandler<T>> handlers = new ArrayList<>();
	protected ContentHandler parent;
	protected XMLReader reader;
	protected String tag;

	public DefaultAttributeHandler(@NonNull String tag) {
		this.tag = tag;
	}

	@Override
	public boolean accept(String localName, Attributes attr) {
		return this.tag.equals(localName);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		this.handlers.stream()
				.filter(attributeHandler -> attributeHandler.accept(localName, attributes))
				.forEach(attributeHandler -> attributeHandler.handle(this.reader, this, this.current, attributes));

		if (this.handlers.stream()
				.noneMatch(attributeHandler -> attributeHandler.accept(localName, attributes))) {
			this.noHandlerFound(uri, localName, qName, attributes);
		}
	}

	protected void noHandlerFound(String uri, String localName, String qName, Attributes attributes) {
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (this.tag.equals(localName)) {
			this.returnToParent(uri, localName, qName);
		}
	}

	protected void returnToParent(String uri, String localName, String qName) throws SAXException {
		this.reader.setContentHandler(this.parent);
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull T current, @NonNull Attributes attr) {
		this.reader = reader;
		this.parent = parent;
		this.current = current;
		reader.setContentHandler(this);
	}

}
