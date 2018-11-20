package br.ufsc.bridge.mpiclient.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import br.ufsc.bridge.metafy.Metafy;
import br.ufsc.bridge.mpiclient.model.dominio.UF;

@Metafy
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RG {
	private LocalDate dataEmissao;
	private String numero;
	private String orgaoEmissor;
	private UF uf;
}
