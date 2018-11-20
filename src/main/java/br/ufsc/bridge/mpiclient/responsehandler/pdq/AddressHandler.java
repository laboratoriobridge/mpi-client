package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.Setter;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.Endereco;
import br.ufsc.bridge.mpiclient.model.dominio.Pais;
import br.ufsc.bridge.mpiclient.model.dominio.TipoEndereco;
import br.ufsc.bridge.mpiclient.model.dominio.TipoLogradouro;
import br.ufsc.bridge.mpiclient.model.dominio.UF;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;
import br.ufsc.bridge.mpiclient.responsehandler.XmlTextHandler;

@Setter(AccessLevel.PRIVATE)
public class AddressHandler extends DefaultAttributeHandler<Cidadao> {

	private Endereco endereco;

	public AddressHandler() {
		super("addr");
		this.handlers.add(new XmlTextHandler("additionalLocator", bairro -> this.endereco.setBairro(bairro)));
		this.handlers.add(new XmlTextHandler("city", codigoMunicipio -> this.endereco.setCodigoMunicipio(codigoMunicipio)));
		this.handlers.add(new XmlTextHandler("postalCode", cep -> this.endereco.setCep(cep)));
		this.handlers.add(new XmlTextHandler("country", codigoPais -> this.endereco.setPais(Pais.getByValue(codigoPais))));
		this.handlers.add(new XmlTextHandler("unitID", complemento -> this.endereco.setComplemento(complemento)));
		this.handlers.add(new XmlTextHandler("streetName", logradouro -> this.endereco.setLogradouro(logradouro)));
		this.handlers.add(new XmlTextHandler("houseNumber", numero -> this.endereco.setNumero(numero)));
		this.handlers.add(new XmlTextHandler("state", siglaEstado -> this.endereco.setUf(UF.getByValue(siglaEstado))));
		this.handlers.add(new XmlTextHandler("streetNameType", codigoTipoLogradouro -> this.endereco.setTipoLogradouro(TipoLogradouro.getByValue(codigoTipoLogradouro))));
	}

	@Override
	public void handle(@NonNull XMLReader reader, @NonNull ContentHandler parent, @NonNull Cidadao current, @NonNull Attributes attr) {
		super.handle(reader, parent, current, attr);
		this.endereco = new Endereco();
		this.endereco.setTipoEndereco(TipoEndereco.getByValue(attr.getValue("use")));
	}

	@Override
	protected void returnToParent(String uri, String localName, String qName) throws SAXException {
		this.current.getEnderecos().add(this.endereco);
		this.endereco = null;

		super.returnToParent(uri, localName, qName);
	}
}
