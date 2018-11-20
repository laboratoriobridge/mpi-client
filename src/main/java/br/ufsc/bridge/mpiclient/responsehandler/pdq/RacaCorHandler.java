package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.dominio.RacaCor;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class RacaCorHandler extends DefaultAttributeHandler<Cidadao> {

	public RacaCorHandler() {
		super("raceCode");
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		current.setRacaCor(RacaCor.getByValue(attr.getValue("code")));
	}
}
