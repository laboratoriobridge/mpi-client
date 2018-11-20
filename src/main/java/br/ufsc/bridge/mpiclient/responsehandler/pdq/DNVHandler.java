package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.Cidadao;

public class DNVHandler extends DocumentHandler {

	public DNVHandler() {
		super("2.16.840.1.113883.13.242");
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		current.setNumeroDnv(attr.getValue("extension"));
	}

}
