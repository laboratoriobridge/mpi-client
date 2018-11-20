package br.ufsc.bridge.mpiclient.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import br.ufsc.bridge.metafy.Metafy;

@Metafy
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class IdentificadorLocal {
	private String idLocal;
	private String nomeSistema;
	private String oidSistema;
}
