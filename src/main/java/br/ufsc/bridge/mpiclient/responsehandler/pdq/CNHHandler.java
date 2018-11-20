package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.CNH;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.dominio.UF;
import br.ufsc.bridge.mpiclient.util.XmlAttributesWrapper;

public class CNHHandler extends DocumentHandler {

	private static final String EXTENSION = "extension";
	private CNH cnh;

	public CNHHandler() {
		super("2.16.840.1.113883.13.238");
	}

	@Override
	protected void noHandlerFound(String uri, String localName, String qName, Attributes attributes) {
		XmlAttributesWrapper wrapper = XmlAttributesWrapper.wrap(attributes);
		String root = wrapper.get("root");
		if ("2.16.840.1.113883.4.707".equals(root)) {
			this.cnh.setUf(UF.getByValue(wrapper.get(EXTENSION)));
		} else if ("2.16.840.1.113883.13.238.1".equals(root)) {
			this.cnh.setDataEmissao(wrapper.getLocalDate(EXTENSION));
		}
	}

	@Override
	protected void returnToParent(String uri, String localName, String qName) throws SAXException {
		this.current.setCnh(this.cnh);

		this.cnh = null;

		super.returnToParent(uri, localName, qName);
	}

	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		this.cnh = new CNH();
		this.cnh.setNumero(attr.getValue(EXTENSION));
	}
}
