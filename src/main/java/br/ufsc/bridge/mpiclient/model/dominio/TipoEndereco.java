package br.ufsc.bridge.mpiclient.model.dominio;

import java.util.Arrays;

public enum TipoEndereco {
	CASA("H"),
	TRABALHO("WP");

	private String value;

	TipoEndereco(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static TipoEndereco getByValue(String value) {
		return Arrays.stream(values())
				.filter(item -> item.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}
}
