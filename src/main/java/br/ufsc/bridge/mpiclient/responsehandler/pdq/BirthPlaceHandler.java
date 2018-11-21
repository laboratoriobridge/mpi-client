package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import br.ufsc.bridge.mpiclient.model.Brasileiro;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.Estrangeiro;
import br.ufsc.bridge.mpiclient.model.Nacionalidade;
import br.ufsc.bridge.mpiclient.model.dominio.Pais;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;
import br.ufsc.bridge.mpiclient.responsehandler.XmlTextHandler;

public class BirthPlaceHandler extends DefaultAttributeHandler<Cidadao> {

	public BirthPlaceHandler() {
		super("birthPlace");
		this.handlers.add(new XmlTextHandler("city", codigoMunicipio ->
				this.current.setNacionalidade(new Brasileiro(codigoMunicipio))
		));

		this.handlers.add(new XmlTextHandler("country", codigoPais -> {
			Nacionalidade nacionalidade = this.current.getNacionalidade();
			if (nacionalidade instanceof Estrangeiro) {
				((Estrangeiro) nacionalidade).setPaisNascimento(Pais.getByValue(codigoPais));
			}
		}));
	}

}
