package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import java.util.function.Consumer;

import org.xml.sax.Attributes;

import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;
import br.ufsc.bridge.mpiclient.responsehandler.XmlTextHandler;

public class NomeHandler extends DefaultAttributeHandler {

	public NomeHandler(Consumer<String> nameConsumer) {
		super("name");
		this.handlers.add(new XmlTextHandler("given", nameConsumer));
	}

	@Override
	public boolean accept(String localName, Attributes attr) {
		return super.accept(localName, attr) && "L".equals(attr.getValue("use"));
	}
}
