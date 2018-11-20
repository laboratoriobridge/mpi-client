package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class OtherIdsHandler extends DefaultAttributeHandler {

	public OtherIdsHandler() {
		super("asOtherIDs");

		this.handlers.add(new CertidaoAntigaHandler());
		this.handlers.add(new CertidaoNovaHandler());
		this.handlers.add(new CNHHandler());
		this.handlers.add(new CNSHandler());
		this.handlers.add(new CPFHandler());
		this.handlers.add(new CTPSHandler());
		this.handlers.add(new DNVHandler());
		this.handlers.add(new NisPisPasepHandler());
		this.handlers.add(new RICHandler());
		this.handlers.add(new TituloEleitorHandler());
		this.handlers.add(new NaturalizadoHandler());
		this.handlers.add(new EstrangeiroHandler());
		this.handlers.add(new RGHandler());
	}

}
