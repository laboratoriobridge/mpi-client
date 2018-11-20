package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class PatientHandler extends DefaultAttributeHandler {

	public PatientHandler() {
		super("patient");
		this.handlers.add(new IdLocalHandler());
		this.handlers.add(new PatientPersonHandler());
		this.handlers.add(new IgnoreAttribute("providerOrganization"));
		this.handlers.add(new IgnoreAttribute("subjectOf1"));
	}

}
