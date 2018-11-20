package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.IdentificadorLocal;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class IdLocalHandler extends DefaultAttributeHandler<Cidadao> {

	public IdLocalHandler() {
		super("id");
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		current.getIdentificadoresLocais().add(new IdentificadorLocal(
				attr.getValue("extension"),
				attr.getValue("assigningAuthorityName"),
				attr.getValue("root")));
	}
}
