package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import org.xml.sax.Attributes;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class NomePaiHandler extends DefaultAttributeHandler<Cidadao> {

	public NomePaiHandler() {
		super("relationshipHolder1");
		this.handlers.add(new NomeHandler(nomePai -> this.current.setNomePai(nomePai)));
	}

	@Override
	public boolean accept(String localName, Attributes attr) {
		return "code".equals(localName) && "NPRN".equals(attr.getValue("code"));
	}
}
