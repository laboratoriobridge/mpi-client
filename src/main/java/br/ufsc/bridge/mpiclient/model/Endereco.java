package br.ufsc.bridge.mpiclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import br.ufsc.bridge.metafy.Metafy;
import br.ufsc.bridge.mpiclient.model.dominio.Pais;
import br.ufsc.bridge.mpiclient.model.dominio.TipoEndereco;
import br.ufsc.bridge.mpiclient.model.dominio.TipoLogradouro;
import br.ufsc.bridge.mpiclient.model.dominio.UF;

@Metafy
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Endereco {
	private String cep;
	private String bairro;
	private String complemento;
	private String codigoMunicipio;
	private String logradouro;
	private String numero;
	private Pais pais;
	private TipoEndereco tipoEndereco;
	private TipoLogradouro tipoLogradouro;
	private UF uf;
}
