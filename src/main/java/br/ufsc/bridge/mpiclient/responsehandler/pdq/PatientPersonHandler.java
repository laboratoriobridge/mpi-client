package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class PatientPersonHandler extends DefaultAttributeHandler<Cidadao> {

	public PatientPersonHandler() {
		super("patientPerson");

		this.handlers.add(new NomeHandler(nome -> this.current.setNome(nome)));
		this.handlers.add(new NomeSocialHandler());
		this.handlers.add(new AdministrativeGenderCodeHandler());
		this.handlers.add(new BirthTimeHandler());
		this.handlers.add(new TelecomHandler());
		this.handlers.add(new DeceasedIndHandler());
		this.handlers.add(new DeceasedTimeHandler());
		this.handlers.add(new PersonalRelationshipHandler());
		this.handlers.add(new AddressHandler());
		this.handlers.add(new RacaCorHandler());
		this.handlers.add(new EtniaHandler());
		this.handlers.add(new OtherIdsHandler());
		this.handlers.add(new BirthPlaceHandler());
	}

}
