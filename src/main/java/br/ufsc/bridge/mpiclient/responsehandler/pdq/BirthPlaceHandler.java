package br.ufsc.bridge.mpiclient.responsehandler.pdq;

import br.ufsc.bridge.mpiclient.model.Brasileiro;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.Estrangeiro;
import br.ufsc.bridge.mpiclient.model.Nacionalidade;
import br.ufsc.bridge.mpiclient.model.Naturalizado;
import br.ufsc.bridge.mpiclient.model.dominio.Pais;
import br.ufsc.bridge.mpiclient.responsehandler.DefaultAttributeHandler;
import br.ufsc.bridge.mpiclient.responsehandler.XmlTextHandler;

public class BirthPlaceHandler extends DefaultAttributeHandler<Cidadao> {

	private String codMunicipio;

	public BirthPlaceHandler() {
		super("birthPlace");
		this.handlers.add(new XmlTextHandler("city", codigoMunicipio ->{
				this.codMunicipio = codigoMunicipio;
				//				this.current.setNacionalidade(new Brasileiro(codigoMunicipio))
		}));

		this.handlers.add(new XmlTextHandler("country", codigoPais -> {
			Nacionalidade nacionalidade = this.current.getNacionalidade();
			if(nacionalidade instanceof Naturalizado && !Pais.BRASIL.getValue().equals(codigoPais)){
				this.current.setNacionalidade(new Estrangeiro(((Naturalizado)this.current.getNacionalidade()).getDataEntradaBrasil(),
						Pais.getByValue(codigoPais)));
			}else if (nacionalidade instanceof Estrangeiro) {
				((Estrangeiro) nacionalidade).setPaisNascimento(Pais.getByValue(codigoPais));
			}else if (this.current.getNacionalidade()==null ){
				this.current.setNacionalidade(new Brasileiro(this.codMunicipio));
			}
		}));
	}

}
