package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.NonNull;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.CertidaoNova;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.dominio.TipoCertidaoNova;
import br.ufsc.bridge.mpiclient.util.XmlAttributesWrapper;

public class CertidaoNovaHandler extends DocumentHandler {

	private static final String EXTENSION = "extension";
	private CertidaoNova certidao;

	public CertidaoNovaHandler() {
		super(
				TipoCertidaoNova.CERTIDAO_DE_CASAMENTO.getRoot(),
				TipoCertidaoNova.CERTIDAO_DE_NASCIMENTO.getRoot(),
				TipoCertidaoNova.CERTIDAO_DE_OBITO.getRoot(),
				TipoCertidaoNova.CERTIDAO_DE_SEPARADO_OU_DIVORCIADO.getRoot(),
				TipoCertidaoNova.RANI_REGISTRO_ADMINISTRATIVO_INDIGENA.getRoot()
		);
	}

	@Override
	protected void noHandlerFound(String uri, String localName, String qName, Attributes attributes) {
		XmlAttributesWrapper wrapper = XmlAttributesWrapper.wrap(attributes);
		String root = wrapper.get("root");
		if ("2.16.840.1.113883.4.706".equals(root)) {
			this.certidao.setMatricula(wrapper.get(EXTENSION));
		} else if ("2.16.840.1.113883.4.706.5".equals(root)) {
			this.certidao.setDataEmissao(wrapper.getLocalDate(EXTENSION));
		}
	}

	@Override
	protected void returnToParent(String uri, String localName, String qName) throws SAXException {
		this.current.getCertidoes().add(this.certidao);

		this.certidao = null;

		super.returnToParent(uri, localName, qName);
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		this.certidao = new CertidaoNova();
		this.certidao.setTipo(TipoCertidaoNova.getByRoot(attr.getValue("root")));
	}
}
