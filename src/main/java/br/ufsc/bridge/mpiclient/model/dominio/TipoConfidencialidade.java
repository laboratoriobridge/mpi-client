package br.ufsc.bridge.mpiclient.model.dominio;

public enum TipoConfidencialidade {
	NORMAL("N", "NORMAL"),
	RESTRITO("R", "RESTRITO"),
	MUITO_RESTRITO("V", "MUITO RESTRITO");

	private String value;
	private String descricao;

	TipoConfidencialidade(String value, String descricao) {
		this.value = value;
		this.descricao = descricao;
	}

	public String getValue() {
		return this.value;
	}

	public String getDescricao() {
		return this.descricao;
	}
}
