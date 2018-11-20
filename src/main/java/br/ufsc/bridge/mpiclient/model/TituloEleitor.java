package br.ufsc.bridge.mpiclient.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import br.ufsc.bridge.metafy.Metafy;

@Metafy
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TituloEleitor {
	private String numero;
	private String zona;
	private String secao;
}
