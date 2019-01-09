package br.ufsc.bridge.mpiclient.model.dominio;

import java.util.Arrays;

public enum TipoLogradouro {
	ACESSO("001", "ACESSO"),
	ADRO("002", "ADRO"),
	ALAMEDA("004", "ALAMEDA"),
	ALTA("005", "ALTA"),
	ATALHO("007", "ATALHO"),
	AVENIDA("008", "AVENIDA"),
	BALNEARIO("009", "BALNEARIO"),
	BELVEDERE("010", "BELVEDERE"),
	BECO("011", "BECO"),
	BLOCO("012", "BLOCO"),
	BOSQUE("013", "BOSQUE"),
	BOULEVARD("014", "BOULEVARD"),
	BAIXA("015", "BAIXA"),
	CAIS("016", "CAIS"),
	CAMINHO("017", "CAMINHO"),
	CHAPADAO("019", "CHAPADAO"),
	CONJUNTO("020", "CONJUNTO"),
	COLONIA("021", "COLONIA"),
	CORREDOR("022", "CORREDOR"),
	CAMPO("023", "CAMPO"),
	CORREGO("024", "CORREGO"),
	DESVIO("027", "DESVIO"),
	DISTRITO("028", "DISTRITO"),
	ESCADA("030", "ESCADA"),
	ESTRADA("031", "ESTRADA"),
	ESTACAO("032", "ESTACAO"),
	ESTADIO("033", "ESTADIO"),
	FAVELA("036", "FAVELA"),
	FAZENDA("037", "FAZENDA"),
	FERROVIA("038", "FERROVIA"),
	FONTE("039", "FONTE"),
	FEIRA("040", "FEIRA"),
	FORTE("043", "FORTE"),
	GALERIA("045", "GALERIA"),
	GRANJA("046", "GRANJA"),
	ILHA("050", "ILHA"),
	JARDIM("052", "JARDIM"),
	LADEIRA("053", "LADEIRA"),
	LARGO("054", "LARGO"),
	LAGOA("055", "LAGOA"),
	LOTEAMENTO("056", "LOTEAMENTO"),
	MORRO("059", "MORRO"),
	MONTE("060", "MONTE"),
	PARALELA("062", "PARALELA"),
	PASSEIO("063", "PASSEIO"),
	PATIO("064", "PATIO"),
	PRACA("065", "PRACA"),
	PARADA("067", "PARADA"),
	PRAIA("070", "PRAIA"),
	PROLONGAMENTO("071", "PROLONGAMENTO"),
	PARQUE("072", "PARQUE"),
	PASSARELA("073", "PASSARELA"),
	PASSAGEM("074", "PASSAGEM"),
	PONTE("076", "PONTE"),
	QUADRA("077", "QUADRA"),
	QUINTA("079", "QUINTA"),
	RUA("081", "RUA"),
	RAMAL("082", "RAMAL"),
	RECANTO("087", "RECANTO"),
	RETIRO("088", "RETIRO"),
	RETA("089", "RETA"),
	RODOVIA("090", "RODOVIA"),
	RETORNO("091", "RETORNO"),
	SITIO("092", "SITIO"),
	SERVIDAO("094", "SERVIDAO"),
	SETOR("095", "SETOR"),
	SUBIDA("096", "SUBIDA"),
	TRINCHEIRA("097", "TRINCHEIRA"),
	TERMINAL("098", "TERMINAL"),
	TREVO("099", "TREVO"),
	TRAVESSA("100", "TRAVESSA"),
	VIA("101", "VIA"),
	VIADUTO("103", "VIADUTO"),
	VILA("104", "VILA"),
	VIELA("105", "VIELA"),
	VALE("106", "VALE"),
	ZIGUE_ZAGUE("108", "ZIGUE-ZAGUE"),
	TRECHO("452", "TRECHO"),
	VEREDA("453", "VEREDA"),
	ARTERIA("465", "ARTERIA"),
	ELEVADA("468", "ELEVADA"),
	PORTO("469", "PORTO"),
	BALAO("470", "BALAO"),
	PARADOURO("471", "PARADOURO"),
	AREA("472", "AREA"),
	JARDINETE("473", "JARDINETE"),
	ESPLANADA("474", "ESPLANADA"),
	QUINTAS("475", "QUINTAS"),
	ROTULA("476", "ROTULA"),
	MARINA("477", "MARINA"),
	DESCIDA("478", "DESCIDA"),
	CIRCULAR("479", "CIRCULAR"),
	UNIDADE("480", "UNIDADE"),
	CHACARA("481", "CHACARA"),
	RAMPA("482", "RAMPA"),
	PONTA("483", "PONTA"),
	VIA_DE_PEDESTRE("484", "VIA_DE_PEDESTRE"),
	CONDOMINIO("485", "CONDOMINIO"),
	NUCLEO_HABITACIONAL("486", "NUCLEO_HABITACIONAL"),
	RESIDENCIAL("487", "RESIDENCIAL"),
	CANAL("495", "CANAL"),
	BURACO("496", "BURACO"),
	MODULO("497", "MODULO"),
	ESTANCIA("498", "ESTANCIA"),
	LAGO("499", "LAGO"),
	NUCLEO("500", "NUCLEO"),
	AEROPORTO("501", "AEROPORTO"),
	PASSAGEM_SUBTERRANEA("502", "PASSAGEM_SUBTERRANEA"),
	COMPLEXO_VIARIO("503", "COMPLEXO_VIARIO"),
	PRACA_DE_ESPORTES("504", "PRACA_DE_ESPORTES"),
	VIA_ELEVADO("505", "VIA_ELEVADO"),
	ROTATORIA("506", "ROTATORIA"),
	TRAVESSA1A("507", "1A_TRAVESSA"),
	TRAVESSA2A("508", "2A_TRAVESSA"),
	TRAVESSA3A("509", "3A_TRAVESSA"),
	RAVESSA4A("510", "4A_TRAVESSA"),
	TRAVESSA5A("511", "5A_TRAVESSA"),
	TRAVESSA6A("512", "6A_TRAVESSA"),
	TRAVESSA7A("513", "7A_TRAVESSA"),
	TRAVESSA8A("514", "8A_TRAVESSA"),
	TRAVESSA9A("515", "9A_TRAVESSA"),
	TRAVESSA10A("516", "10A_TRAVESSA"),
	TRAVESSA11A("517", "11A_TRAVESSA"),
	TRAVESSA12A("518", "12A_TRAVESSA"),
	TRAVESSA13A("519", "13A_TRAVESSA"),
	TRAVESSA14A("520", "14A_TRAVESSA"),
	TRAVESSA15A("521", "15A_TRAVESSA"),
	TRAVESSA16A("522", "16A_TRAVESSA"),
	ALTA1O("523", "1O_ALTA"),
	ALTA2O("524", "2O_ALTA"),
	ALTA3O("525", "3O_ALTA"),
	ALTA4O("526", "4O_ALTA"),
	ALTA5O("527", "5O_ALTA"),
	BECO1O("528", "1O_BECO"),
	BECO2O("529", "2O_BECO"),
	BECO3O("530", "3O_BECO"),
	BECO4O("531", "4O_BECO"),
	BECO5O("532", "5O_BECO"),
	PARALELA1A("533", "1A_PARALELA"),
	PARALELA2A("534", "2A_PARALELA"),
	PARALELA3A("535", "3A_PARALELA"),
	PARALELA4A("536", "4A_PARALELA"),
	PARALELA5A("537", "5A_PARALELA"),
	SUBIDA1A("538", "1A_SUBIDA"),
	SUBIDA2A("539", "2A_SUBIDA"),
	SUBIDA3A("540", "3A_SUBIDA"),
	SUBIDA4A("541", "4A_SUBIDA"),
	SUBIDA5A("542", "5A_SUBIDA"),
	SUBIDA6A("543", "6A_SUBIDA"),
	VILA1A("544", "1A_VILA"),
	VILA2A("545", "2A_VILA"),
	VILA3A("546", "3A_VILA"),
	VILA4A("547", "4A_VILA"),
	VILA5A("548", "5A_VILA"),
	PARQUE1O("549", "1O_PARQUE"),
	PARQUE2O("550", "2O_PARQUE"),
	PARQUE3O("551", "3O_PARQUE"),
	RUA1A("552", "1A_RUA"),
	RUA2A("553", "2A_RUA"),
	RUA3A("554", "3A_RUA"),
	RUA5A("555", "5A_RUA"),
	RUA4A("556", "4A_RUA"),
	RUA6A("557", "6A_RUA"),
	RUA7A("558", "7A_RUA"),
	RUA8A("559", "8A_RUA"),
	RUA9A("560", "9A_RUA"),
	RUA10A("561", "10A_RUA"),
	RUA11A("562", "11A_RUA"),
	RUA12A("563", "12A_RUA"),
	ESTACIONAMENTO("564", "ESTACIONAMENTO"),
	VALA("565", "VALA"),
	RUA_DE_PEDESTRE("566", "RUA_DE_PEDESTRE"),
	TUNEL("567", "TUNEL"),
	VARIANTE("568", "VARIANTE"),
	RODO_ANEL("569", "RODO_ANEL"),
	TRAVESSA_PARTICULAR("570", "TRAVESSA_PARTICULAR"),
	CALCADA("571", "CALCADA"),
	VIA_DE_ACESSO("572", "VIA_DE_ACESSO"),
	ENTRADA_PARTICULAR("573", "ENTRADA_PARTICULAR"),
	ACAMPAMENTO("645", "ACAMPAMENTO"),
	VIA_EXPRESSA("646", "VIA_EXPRESSA"),
	ESTRADA_MUNICIPAL("650", "ESTRADA_MUNICIPAL"),
	AVENIDA_CONTORNO("651", "AVENIDA_CONTORNO"),
	ENTRE_QUADRA("652", "ENTRE_QUADRA"),
	RUA_DE_LIGACAO("653", "RUA_DE_LIGACAO"),
	AREA_ESPECIAL("654", "AREA_ESPECIAL"),
	AVENIDA1A("655", "1A_AVENIDA"),
	AVENIDA2A("656", "2A_AVENIDA"),
	AVENIDA3A("657", "3A_AVENIDA"),
	AVENIDA4A("658", "4A_AVENIDA"),
	TRAVESSA18A("659", "18A_TRAVESSA"),
	TRAVESSA19A("660", "19A_TRAVESSA"),
	AVENIDA5A("661", "5A_AVENIDA"),
	RECREIO("662", "RECREIO"),
	PARQUE_MUNICIPAL("663", "PARQUE_MUNICIPAL"),
	CONJUNTO_MUTIRAO("664", "CONJUNTO_MUTIRAO"),
	PARQUE_RESIDENCIAL("665", "PARQUE_RESIDENCIAL"),
	VIA_LOCAL("666", "VIA_LOCAL"),
	ACESSO_LOCAL("667", "ACESSO_LOCAL"),
	VIA_COLETORA("668", "VIA_COLETORA"),
	RUA_PARTICULAR("669", "RUA_PARTICULAR"),
	RUA_INTEGRACAO("670", "RUA_INTEGRACAO"),
	ESTRADA_VELHA("671", "ESTRADA_VELHA"),
	RUA_VELHA("672", "RUA_VELHA"),
	TRAVESSA_VELHA("673", "TRAVESSA_VELHA"),
	ANTIGA_ESTRADA("674", "ANTIGA_ESTRADA"),
	ESTRADA_DE_LIGACAO("675", "ESTRADA_DE_LIGACAO"),
	ESTRADA_ESTADUAL("676", "ESTRADA_ESTADUAL"),
	AVENIDA_MARGINAL("677", "AVENIDA_MARGINAL"),
	AVENIDA_VELHA("678", "AVENIDA_VELHA"),
	AVENIDA_MARGINAL_ESQUERDA("679", "AVENIDA_MARGINAL_ESQUERDA"),
	AVENIDA_MARGINAL_DIREITA("680", "AVENIDA_MARGINAL_DIREITA"),
	ESTRADA_PARTICULAR("681", "ESTRADA_PARTICULAR"),
	ESTRADA_ANTIGA("682", "ESTRADA_ANTIGA"),
	AVENIDA6A("683", "6A_AVENIDA"),
	VIA_LITORANEA("685", "VIA_LITORANEA"),
	CONTORNO("686", "CONTORNO"),
	BLOCOS("687", "BLOCOS"),
	CICLOVIA("688", "CICLOVIA"),
	BULEVAR("689", "BULEVAR"),
	ESCADARIA("690", "ESCADARIA"),
	PRIMEIRA_LADEIRA("691", "PRIMEIRA_LADEIRA"),
	LADEIRA2A("692", "2A_LADEIRA"),
	LADEIRA3A("693", "3A_LADEIRA"),
	QUARTA_LADEIRA("694", "QUARTA_LADEIRA"),
	QUINTA_LADEIRA("695", "QUINTA_LADEIRA"),
	PASSAGEM_DE_PEDESTRES("696", "PASSAGEM_DE_PEDESTRES"),
	ESTRADA_VICINAL("697", "ESTRADA_VICINAL"),
	RUA_PROJETADA("698", "RUA_PROJETADA"),
	RUA_PRINCIPAL("699", "RUA_PRINCIPAL"),
	TERCEIRA_AVENIDA("700", "TERCEIRA_AVENIDA"),
	SEGUNDA_AVENIDA("701", "SEGUNDA_AVENIDA"),
	PASSEIO_PUBLICO("702", "PASSEIO_PUBLICO"),
	ENTRE_BLOCO("704", "ENTRE_BLOCO"),
	ENSEADA("705", "ENSEADA"),
	ILHOTA("706", "ILHOTA"),
	VIA_DE_PEDESTRES("707", "VIA_DE_PEDESTRES"),
	TRAVESSA_DA_RODOVIA2A("708", "2A_TRAVESSA_DA_RODOVIA"),
	TRAVESSA_DA_RODOVIA1A("709", "1A_TRAVESSA_DA_RODOVIA"),
	ESTRADA_INTERMUNICIPAL("710", "ESTRADA_INTERMUNICIPAL"),
	VIA_COSTEIRA("711", "VIA_COSTEIRA"),
	ESTRADA_DE_SERVIDAO("712", "ESTRADA_DE_SERVIDAO"),
	COMUNIDADE("713", "COMUNIDADE"),
	EIXO_INDUSTRIAL("714", "EIXO_INDUSTRIAL"),
	MERCADO("715", "MERCADO"),
	EVANGELICA("716", "EVANGELICA"),
	CAMPUS("717", "CAMPUS"),
	PROJECAO("718", "PROJECAO"),
	NUCLEO_RURAL("719", "NUCLEO_RURAL"),
	MARGEM("720", "MARGEM"),
	AREA_VERDE("721", "AREA_VERDE"),
	CONDOMINIO_RESIDENCIAL("722", "CONDOMINIO_RESIDENCIAL"),
	CALCADAO("723", "CALCADAO"),
	RUELA("724", "RUELA"),
	AVENIDA_PERIMETRAL("725", "AVENIDA_PERIMETRAL"),
	VIA_PRINCIPAL("726", "VIA_PRINCIPAL"),
	VIA_PEDESTRE("727", "VIA_PEDESTRE"),
	VIA_LATERAL("728", "VIA_LATERAL"),
	CAMINHO_DE_SERVIDAO("729", "CAMINHO_DE_SERVIDAO"),
	AVENIDA_MARGINAL_NORTE("730", "AVENIDA_MARGINAL_NORTE"),
	ESTRADA_DE_FERRO("731", "ESTRADA_DE_FERRO"),
	EIXO_PRINCIPAL("732", "EIXO_PRINCIPAL"),
	EIXO("733", "EIXO"),
	OUTEIRO("734", "OUTEIRO"),
	ESTRADA_NOVA("735", "ESTRADA_NOVA"),
	CONJUNTO_HABITACIONAL("736", "CONJUNTO_HABITACIONAL"),
	JARDIM_RESIDENCIAL("737", "JARDIM_RESIDENCIAL"),
	ANEL_VIARIO("738", "ANEL_VIARIO"),
	SERVIDAO_DE_PASSAGEM("739", "SERVIDAO_DE_PASSAGEM"),
	TRAVESSA17A("740", "17A_TRAVESSA"),
	ANTIGA_ESTACAO("741", "ANTIGA_ESTACAO"),
	TRAVESSA20A("742", "20A_TRAVESSA"),
	TRAVESSA21A("743", "21A_TRAVESSA"),
	TRAVESSA22A("744", "22A_TRAVESSA"),
	CONJUNTO_RESIDENCIAL("745", "CONJUNTO_RESIDENCIAL"),
	ALAMEDA2A("746", "2A_ALAMEDA"),
	VARIANTE_DA_ESTRADA("747", "VARIANTE_DA_ESTRADA"),
	VIA_MARGINAL("748", "VIA_MARGINAL"),
	MODULO_COMERCIAL("749", "MODULO_COMERCIAL"),
	NOVA_AVENIDA("750", "NOVA_AVENIDA"),
	GLEBA("751", "GLEBA"),
	ALDEIA("998", "ALDEIA"),
	INVALIDO("999", "INVÁLIDO");

	private String value;
	private String descricao;

	TipoLogradouro(String value, String descricao) {
		this.value = value;
		this.descricao = descricao;
	}

	public String getValue() {
		return this.value;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static TipoLogradouro getByValue(String value) {
		return Arrays.stream(values())
				.filter(item -> item.getValue().equals(value))
				.findFirst()
				.orElse(null);
	}
}