package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class PersonalRelationshipHandler extends DefaultAttributeHandler {

	public PersonalRelationshipHandler() {
		super("personalRelationship");
		this.handlers.add(new NomeMaeHandler());
		this.handlers.add(new NomePaiHandler());
	}

}
