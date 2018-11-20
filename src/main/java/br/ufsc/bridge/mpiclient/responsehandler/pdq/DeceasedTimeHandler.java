package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class DeceasedTimeHandler extends DefaultAttributeHandler<Cidadao> {

	public DeceasedTimeHandler() {
		super("deceasedTime");
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		current.setDataObito(LocalDate.parse(attr.getValue("value"), DateTimeFormatter.ofPattern("yyyyMMddHHmmss")));
	}
}
