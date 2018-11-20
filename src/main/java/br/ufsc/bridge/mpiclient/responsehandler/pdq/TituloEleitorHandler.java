package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.TituloEleitor;
import br.ufsc.bridge.mpiclient.util.XmlAttributesWrapper;

public class TituloEleitorHandler extends DocumentHandler {

	private static final String EXTENSION = "extension";
	private TituloEleitor tituloEleitor;

	public TituloEleitorHandler() {
		super("2.16.840.1.113883.13.239");
	}

	@Override
	protected void noHandlerFound(String uri, String localName, String qName, Attributes attributes) {
		XmlAttributesWrapper wrapper = XmlAttributesWrapper.wrap(attributes);
		String root = wrapper.get("root");
		if ("2.16.840.1.113883.13.239.1".equals(root)) {
			this.tituloEleitor.setZona(wrapper.get(EXTENSION));
		} else if ("2.16.840.1.113883.13.239.2".equals(root)) {
			this.tituloEleitor.setSecao(wrapper.get(EXTENSION));
		}
	}

	@Override
	protected void returnToParent(String uri, String localName, String qName) throws SAXException {
		this.current.setTituloEleitor(this.tituloEleitor);

		this.tituloEleitor = null;

		super.returnToParent(uri, localName, qName);
	}

	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		this.tituloEleitor = new TituloEleitor();
		this.tituloEleitor.setNumero(attr.getValue(EXTENSION));
	}
}
