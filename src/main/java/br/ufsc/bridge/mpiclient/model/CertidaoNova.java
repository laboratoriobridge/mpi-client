package br.ufsc.bridge.mpiclient.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import br.ufsc.bridge.metafy.Metafy;
import br.ufsc.bridge.mpiclient.model.dominio.TipoCertidaoNova;

@Metafy
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CertidaoNova implements Certidao {
	private String matricula;
	private LocalDate dataEmissao;
	private TipoCertidaoNova tipo;
}
