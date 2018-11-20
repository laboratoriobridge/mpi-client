package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.CNS;
import br.ufsc.bridge.mpiclient.model.Cidadao;

public class CNSHandler extends DocumentHandler {

	public CNSHandler() {
		super("2.16.840.1.113883.13.236");
	}

	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		current.getCnss().add(new CNS(attr.getValue("extension")));
	}
}
