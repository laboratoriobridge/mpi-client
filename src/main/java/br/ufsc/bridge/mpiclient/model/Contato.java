package br.ufsc.bridge.mpiclient.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import br.ufsc.bridge.metafy.Metafy;
import br.ufsc.bridge.mpiclient.model.dominio.TipoContato;

@Metafy
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Contato {
	private String value;
	private TipoContato tipo;
	private Boolean removerContato;
}
