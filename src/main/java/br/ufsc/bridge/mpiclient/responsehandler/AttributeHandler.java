package br.ufsc.bridge.mpiclient.responsehandler;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

public interface AttributeHandler<T> {

	boolean accept(String qName, Attributes attr);

	void handle(XMLReader reader, ContentHandler parent, T current, Attributes attr);

}
