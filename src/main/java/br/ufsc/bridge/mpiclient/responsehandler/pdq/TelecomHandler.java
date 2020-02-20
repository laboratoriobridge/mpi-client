package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.Contato;
import br.ufsc.bridge.mpiclient.model.dominio.TipoContato;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class TelecomHandler extends DefaultAttributeHandler<Cidadao> {

	public TelecomHandler() {
		super("telecom");
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		current.getContatos().add(new Contato(attr.getValue("value"), TipoContato.getByValue(attr.getValue("use")),false));
	}
}
