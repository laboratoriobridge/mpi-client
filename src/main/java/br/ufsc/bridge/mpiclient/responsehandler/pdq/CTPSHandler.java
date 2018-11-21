package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.CTPS;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.util.XmlAttributesWrapper;

public class CTPSHandler extends DocumentHandler {

	private static final String EXTENSION = "extension";
	private CTPS ctps;

	public CTPSHandler() {
		super("2.16.840.1.113883.13.244");
	}

	@Override
	protected void noHandlerFound(String uri, String localName, String qName, Attributes attributes) {
		XmlAttributesWrapper wrapper = XmlAttributesWrapper.wrap(attributes);
		String root = wrapper.get("root");
		if ("2.16.840.1.113883.13.244.1".equals(root)) {
			this.ctps.setSerie(wrapper.get(EXTENSION));
		} else if ("2.16.840.1.113883.13.244.2".equals(root)) {
			this.ctps.setDataEmissao(wrapper.getLocalDate(EXTENSION));
		}
	}

	@Override
	protected void returnToParent(String uri, String localName, String qName) throws SAXException {
		this.current.setCtps(this.ctps);

		this.ctps = null;

		super.returnToParent(uri, localName, qName);
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		this.ctps = new CTPS();
		this.ctps.setNumero(attr.getValue(EXTENSION));
	}
}
