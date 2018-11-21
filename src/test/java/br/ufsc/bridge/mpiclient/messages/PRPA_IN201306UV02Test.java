package br.ufsc.bridge.mpiclient.messages;

import static br.ufsc.bridge.mpiclient.model.MCidadao.meta;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import br.ufsc.bridge.mpiclient.exceptions.MPIXmlParseException;
import br.ufsc.bridge.mpiclient.model.CNS;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.model.IdentificadorLocal;
import br.ufsc.bridge.mpiclient.model.MBrasileiro;
import br.ufsc.bridge.mpiclient.model.MEndereco;
import br.ufsc.bridge.mpiclient.model.MRG;
import br.ufsc.bridge.mpiclient.model.dominio.Pais;
import br.ufsc.bridge.mpiclient.model.dominio.RacaCor;
import br.ufsc.bridge.mpiclient.model.dominio.Sexo;
import br.ufsc.bridge.mpiclient.model.dominio.TipoConfidencialidade;
import br.ufsc.bridge.mpiclient.model.dominio.TipoEndereco;
import br.ufsc.bridge.mpiclient.model.dominio.TipoLogradouro;
import br.ufsc.bridge.mpiclient.model.dominio.UF;

public class PRPA_IN201306UV02Test {

	@Test
	public void severinoFaustino() throws MPIXmlParseException {
		InputStream stream = this.getClass().getResourceAsStream("/responses/SeverinoFaustino.xml");
		List<Cidadao> read = new PDQResponseMessage().read(stream);

		assertThat(read).hasSize(1);

		Cidadao cidadao = read.get(0);

		assertThat(cidadao)
				.hasFieldOrPropertyWithValue(meta.dataNascimento.getAlias(), LocalDate.of(1938, 06, 25))
				.hasFieldOrPropertyWithValue(meta.nome.getAlias(), "SEVERINO FAUSTINO")
				.hasFieldOrPropertyWithValue(meta.nomeMae.getAlias(), "AMALIA COELHO DE MELO")
				.hasFieldOrPropertyWithValue(meta.nomePai.getAlias(), "SEM INFORMAÇÃO")
				.hasFieldOrPropertyWithValue(meta.racaCor.getAlias(), RacaCor.PRETA)
				.hasFieldOrPropertyWithValue(meta.sexo.getAlias(), Sexo.MASCULINO)
				.hasFieldOrPropertyWithValue(meta.tipoConfidencialidade.getAlias(), TipoConfidencialidade.NORMAL);

		assertThat(cidadao.getCnss())
				.containsOnly(new CNS("898002940850595"));

		assertThat(cidadao.getEnderecos().get(0))
				.hasFieldOrPropertyWithValue(MEndereco.meta.bairro.getAlias(), "CIDADE DE DEUS")
				.hasFieldOrPropertyWithValue(MEndereco.meta.cep.getAlias(), "22763550")
				.hasFieldOrPropertyWithValue(MEndereco.meta.codigoMunicipio.getAlias(), "330455")
				.hasFieldOrPropertyWithValue(MEndereco.meta.complemento.getAlias(), "FDS CASA")
				.hasFieldOrPropertyWithValue(MEndereco.meta.logradouro.getAlias(), "DA BIBLIA")
				.hasFieldOrPropertyWithValue(MEndereco.meta.numero.getAlias(), "64")
				.hasFieldOrPropertyWithValue(MEndereco.meta.pais.getAlias(), Pais.BRASIL)
				.hasFieldOrPropertyWithValue(MEndereco.meta.tipoEndereco.getAlias(), TipoEndereco.CASA)
				.hasFieldOrPropertyWithValue(MEndereco.meta.tipoLogradouro.getAlias(), TipoLogradouro.PRACA);

		assertThat(cidadao.getIdentificadoresLocais())
				.containsOnly(
						new IdentificadorLocal("185086693", "CADSUS-BULK", "2.16.840.1.113883.3.4594.3"),
						new IdentificadorLocal("0001753000", "CADSUS-UPDATE", "2.16.840.1.113883.3.4594.2"),
						new IdentificadorLocal("0001753000", "RES-BRASIL", "2.16.840.1.113883.3.4594")
				);

		assertThat(cidadao.getNacionalidade())
				.hasFieldOrPropertyWithValue(MBrasileiro.meta.codigoMunicipioNascimento.getAlias(), "330455")
				.hasFieldOrPropertyWithValue(MBrasileiro.meta.paisNascimento.getAlias(), Pais.BRASIL);

		assertThat(cidadao.getRg())
				.hasFieldOrPropertyWithValue(MRG.meta.dataEmissao.getAlias(), LocalDate.of(1989, 01, 27))
				.hasFieldOrPropertyWithValue(MRG.meta.numero.getAlias(), "01350389")
				.hasFieldOrPropertyWithValue(MRG.meta.orgaoEmissor.getAlias(), "81")
				.hasFieldOrPropertyWithValue(MRG.meta.uf.getAlias(), UF.RIO_DE_JANEIRO);
	}

}

