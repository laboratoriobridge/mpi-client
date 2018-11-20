package br.ufsc.bridge.mpiclient.model.dominio;

import java.util.Arrays;

public enum RacaCor {
	BRANCA("01", "BRANCA"),
	PRETA("02", "PRETA"),
	PARDA("03", "PARDA"),
	AMARELA("04", "AMARELA"),
	INDIGENA("05", "INDIGENA"),
	SEMINFORMACAO("99", "SEMINFORMACAO");

	private String value;
	private String descricao;

	RacaCor(String value, String descricao) {
		this.value = value;
		this.descricao = descricao;
	}

	public String getValue() {
		return this.value;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static RacaCor getByValue(String value) {
		return Arrays.stream(values())
				.filter(item -> item.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}
}
