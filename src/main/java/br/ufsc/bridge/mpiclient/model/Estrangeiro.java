package br.ufsc.bridge.mpiclient.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import br.ufsc.bridge.mpiclient.model.dominio.Pais;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Estrangeiro implements Nacionalidade {
	private LocalDate dataEntradaBrasil;
	private Pais paisNascimento;
}
