package br.ufsc.bridge.mpiclient.model.dominio;

import java.util.Arrays;

public enum Sexo {
	MASCULINO("M"),
	FEMININO("F"),
	IGNORADO("I");

	private String value;

	Sexo(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static Sexo getByValue(String value) {
		return Arrays.stream(values())
				.filter(sexo -> sexo.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}
}
