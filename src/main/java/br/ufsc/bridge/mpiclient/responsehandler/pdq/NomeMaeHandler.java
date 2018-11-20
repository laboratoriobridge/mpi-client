package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import org.xml.sax.Attributes;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class NomeMaeHandler extends DefaultAttributeHandler<Cidadao> {

	public NomeMaeHandler() {
		super("relationshipHolder1");
		this.handlers.add(new NomeHandler(nomeMae -> this.current.setNomeMae(nomeMae)));
	}

	@Override
	public boolean accept(String localName, Attributes attr) {
		return "code".equals(localName) && "PRN".equals(attr.getValue("code"));
	}
}
