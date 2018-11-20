package br.ufsc.bridge.mpiclient.model.dominio;

import java.util.Arrays;

public enum TipoCertidaoAntiga {
	CERTIDAO_DE_OBITO("15", "CERTIDÃO DE ÓBITO", "2.16.840.1.113883.13.241.10"),
	CERTIDAO_DE_NASCIMENTO("91", "CERTIDÃO DE NASCIMENTO", "2.16.840.1.113883.13.241.2"),
	CERTIDAO_DE_CASAMENTO("92", "CERTIDÃO DE CASAMENTO", "2.16.840.1.113883.13.241.4"),
	CERTIDAO_DE_SEPARADO_OU_DIVORCIADO("93", "CERTIDÃO DE SEPARADO OU DIVORCIADO", "2.16.840.1.113883.13.241.6"),
	RANI_REGISTRO_ADMINISTRATIVO_INDIGENA("95", "RANI-REGISTRO ADMINISTRATIVO INDIGENA", "2.16.840.1.113883.13.241.8");

	private String value;
	private String descricao;
	private String root;

	TipoCertidaoAntiga(String value, String descricao, String root) {
		this.value = value;
		this.descricao = descricao;
		this.root = root;
	}

	public String getValue() {
		return this.value;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getRoot() {
		return this.root;
	}

	public static TipoCertidaoAntiga getByRoot(String root) {
		return Arrays.stream(values())
				.filter(item -> item.getRoot().equals(root))
				.findFirst()
				.orElse(null);
	}
}
