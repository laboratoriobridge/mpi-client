package br.ufsc.bridge.mpiclient.model.dominio;

import java.util.Arrays;

public enum UF {
	ACRE("AC", "ACRE"),
	ALAGOAS("AL", "ALAGOAS"),
	AMAZONAS("AM", "AMAZONAS"),
	AMAPA("AP", "AMAPA"),
	BAHIA("BA", "BAHIA"),
	CEARA("CE", "CEARA"),
	DISTRITO_FEDERAL("DF", "DISTRITO_FEDERAL"),
	ESPIRITO_SANTO("ES", "ESPIRITO_SANTO"),
	GOIAS("GO", "GOIAS"),
	MARANHAO("MA", "MARANHAO"),
	MINAS_GERAIS("MG", "MINAS_GERAIS"),
	MATO_GROSSO_DO_SUL("MS", "MATO_GROSSO_DO_SUL"),
	MATO_GROSSO("MT", "MATO_GROSSO"),
	PARA("PA", "PARA"),
	PARAIBA("PB", "PARAIBA"),
	PERNAMBUCO("PE", "PERNAMBUCO"),
	PIAUI("PI", "PIAUI"),
	PARANA("PR", "PARANA"),
	RIO_DE_JANEIRO("RJ", "RIO_DE_JANEIRO"),
	RIO_GRANDE_DO_NORTE("RN", "RIO_GRANDE_DO_NORTE"),
	RONDONIA("RO", "RONDONIA"),
	RORAIMA("RR", "RORAIMA"),
	RIO_GRANDE_DO_SUL("RS", "RIO_GRANDE_DO_SUL"),
	SANTA_CATARINA("SC", "SANTA_CATARINA"),
	SERGIPE("SE", "SERGIPE"),
	SAO_PAULO("SP", "SAO_PAULO"),
	TOCANTINS("TO", "TOCANTINS");

	private String value;
	private String descricao;

	UF(String value, String descricao) {
		this.value = value;
		this.descricao = descricao;
	}

	public String getValue() {
		return this.value;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static UF getByValue(String value) {
		return Arrays.stream(values())
				.filter(item -> item.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}
}
