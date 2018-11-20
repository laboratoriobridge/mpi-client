package br.ufsc.bridge.mpiclient.model.dominio;

import java.util.Arrays;

public enum TipoContato {
	TELEFONE_RESIDENCIAL("PRN"),
	TELEFONE_COMERCIAL("WPN"),
	TELEFONE_CONTATO("EMR"),
	TELEFONE_OUTROS("ORN"),
	EMAIL("NET"),
	CELULAR("ASN");

	private String value;

	TipoContato(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static TipoContato getByValue(String value) {
		return Arrays.stream(values())
				.filter(tipoContato -> tipoContato.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}
}
