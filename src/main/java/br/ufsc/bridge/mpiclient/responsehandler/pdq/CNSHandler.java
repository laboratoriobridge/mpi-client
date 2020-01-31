package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.CNS;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.util.XmlAttributesWrapper;

public class CNSHandler extends DocumentHandler {

	private CNS cns;

	public CNSHandler() {
		super("2.16.840.1.113883.13.236");
	}

	@Override protected void noHandlerFound(String uri, String localName, String qName, Attributes attributes) {
		XmlAttributesWrapper wrapper = XmlAttributesWrapper.wrap(attributes);
		String root = wrapper.get("root");
		if ("2.16.840.1.113883.13.236.1".equals(root)) {
			this.cns.setSituacao(wrapper.get("extension"));
		}
	}

	@Override
	protected void returnToParent(String uri, String localName, String qName) throws SAXException {
		this.current.getCnss().add(this.cns);

		this.cns = null;

		super.returnToParent(uri, localName, qName);
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		this.cns = new CNS();
		this.cns.setNumero(attr.getValue("extension"));
	}
}
