package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.Naturalizado;
import br.ufsc.bridge.mpiclient.util.XmlAttributesWrapper;

public class NaturalizadoHandler extends DocumentHandler {

	private static final String EXTENSION = "extension";
	private Naturalizado naturalizado;

	public NaturalizadoHandler() {
		super("2.16.840.1.113883.4.713");
	}

	@Override
	protected void noHandlerFound(String uri, String localName, String qName, Attributes attributes) {
		XmlAttributesWrapper wrapper = XmlAttributesWrapper.wrap(attributes);
		String root = wrapper.get("root");
		if ("2.16.840.1.113883.4.713.1".equals(root)) {
			this.naturalizado.setDataEntradaBrasil(wrapper.getLocalDate(EXTENSION));
		} else if ("2.16.840.1.113883.4.713.2".equals(root)) {
			this.naturalizado.setDataNaturalizacao(wrapper.getLocalDate(EXTENSION));
		}
	}

	@Override
	protected void returnToParent(String uri, String localName, String qName) throws SAXException {
		this.current.setNacionalidade(this.naturalizado);

		this.naturalizado = null;

		super.returnToParent(uri, localName, qName);
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		this.naturalizado = new Naturalizado();
		this.naturalizado.setNumeroPortaria(attr.getValue(EXTENSION));
	}
}
