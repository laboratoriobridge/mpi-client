package br.ufsc.bridge.mpiclient.api;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

import br.ufsc.bridge.mpiclient.model.dominio.Sexo;

@Getter
@Builder
public class PDQParameters {

	private String cns;
	private String codigoMunicipioNascimento;
	private String cpf;
	private LocalDate dataNascimento;
	private String idLocal;
	private String nome;
	private String nomeMae;
	private String numeroNisPisPasep;
	private String oidSistema;
	private Sexo sexo;

}
