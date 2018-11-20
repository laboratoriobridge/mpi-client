package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.RG;
import br.ufsc.bridge.mpiclient.model.dominio.UF;
import br.ufsc.bridge.mpiclient.util.XmlAttributesWrapper;

public class RGHandler extends DocumentHandler {

	private static final String EXTENSION = "extension";
	private RG rg;

	public RGHandler() {
		super("2.16.840.1.113883.13.243");
	}

	@Override
	protected void noHandlerFound(String uri, String localName, String qName, Attributes attributes) {
		XmlAttributesWrapper wrapper = XmlAttributesWrapper.wrap(attributes);
		String root = wrapper.get("root");
		if ("2.16.840.1.113883.13.245".equals(root)) {
			this.rg.setOrgaoEmissor(wrapper.get(EXTENSION));
		} else if ("2.16.840.1.113883.4.707".equals(root)) {
			this.rg.setUf(UF.getByValue(wrapper.get(EXTENSION)));
		} else if ("2.16.840.1.113883.13.243.1".equals(root)) {
			this.rg.setDataEmissao(wrapper.getLocalDate(EXTENSION));
		}
	}

	@Override
	protected void returnToParent(String uri, String localName, String qName) throws SAXException {
		this.current.setRg(this.rg);

		this.rg = null;

		super.returnToParent(uri, localName, qName);
	}

	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		this.rg = new RG();
		this.rg.setNumero(attr.getValue(EXTENSION));
	}
}
