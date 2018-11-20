package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import org.xml.sax.Attributes;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;
import br.ufsc.bridge.mpiclient.responsehandler.XmlTextHandler;

public class NomeSocialHandler extends DefaultAttributeHandler<Cidadao> {

	public NomeSocialHandler() {
		super("name");
		this.handlers.add(new XmlTextHandler("given", nomeSocial -> this.current.setNomeSocial(nomeSocial)));
	}

	@Override
	public boolean accept(String localName, Attributes attr) {
		return super.accept(localName, attr) && "ASGN".equals(attr.getValue("use"));
	}
}
