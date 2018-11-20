package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import java.util.Arrays;
import java.util.List;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;

public class DocumentHandler extends DefaultAttributeHandler<Cidadao> {

	private List<String> oidsDocument;

	public DocumentHandler(@NonNull String... oidDocument) {
		super("asOtherIDs");
		this.oidsDocument = Arrays.asList(oidDocument);
		this.handlers.add(new IgnoreAttribute("scopingOrganization"));
	}

	@Override
	protected void returnToParent(String uri, String localName, String qName) throws SAXException {
		super.returnToParent(uri, localName, qName);
		this.parent.endElement(uri, localName, qName);
	}

	@Override
	public boolean accept(String localName, Attributes attr) {
		return "id".equals(localName) && this.oidsDocument.contains(attr.getValue("root"));
	}
}
