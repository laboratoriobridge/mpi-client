package br.ufsc.bridge.mpiclient.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import br.ufsc.bridge.metafy.Metafy;
import br.ufsc.bridge.mpiclient.model.dominio.Pais;

@Getter
@Metafy
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Brasileiro implements Nacionalidade {
	private String codigoMunicipioNascimento;
	private final Pais paisNascimento = Pais.BRASIL;
}
