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
public class Naturalizado implements Nacionalidade {

	private LocalDate dataEntradaBrasil;

	private LocalDate dataNaturalizacao;

	private String numeroPortaria;

	private Pais paisNascimento = Pais.BRASIL;

	public Naturalizado(LocalDate dataEntradaBrasil,LocalDate dataNaturalizacao,String numeroPortaria){
			this.dataEntradaBrasil = dataEntradaBrasil;
			this.dataNaturalizacao = dataNaturalizacao;
			this.numeroPortaria = numeroPortaria;
	}
}
