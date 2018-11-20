package br.ufsc.bridge.mpiclient.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import br.ufsc.bridge.metafy.Metafy;
import br.ufsc.bridge.mpiclient.model.dominio.Pais;

@Metafy
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Passaporte {
	private LocalDate dataEmissao;
	private LocalDate dataValidade;
	private String numero;
	private Pais paisOrigem;
}
