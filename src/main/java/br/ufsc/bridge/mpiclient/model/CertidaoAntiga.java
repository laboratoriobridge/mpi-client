package br.ufsc.bridge.mpiclient.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import br.ufsc.bridge.metafy.Metafy;
import br.ufsc.bridge.mpiclient.model.dominio.TipoCertidaoAntiga;

@Metafy
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CertidaoAntiga implements Certidao {
	private String cartorio;
	private LocalDate dataEmissao;
	private String folha;
	private String livro;
	private String termo;
	private TipoCertidaoAntiga tipo;
}
