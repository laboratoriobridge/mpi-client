package br.ufsc.bridge.mpiclient.messages;

import static java.util.Optional.ofNullable;

import java.time.LocalDateTime;
import java.util.HashMap;

import br.ufsc.bridge.mpiclient.exceptions.MPIValidationException;
import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.mpiclient.thymeleaf.TemplateSerializer;
import br.ufsc.bridge.mpiclient.validator.CidadaoValidator;
import br.ufsc.bridge.platform.validation.form.errors.FormErrorImpl;

/**
 * IHE transaction ITI-44 (Record added)
 * PRPA_IN201301UV02
 */
public class PIXRequestMessage {

	public String create(Cidadao cidadao, LocalDateTime requestTime) throws MPIValidationException {
		FormErrorImpl error = new FormErrorImpl(cidadao);
		new CidadaoValidator().validate(cidadao, error);

		if (!error.isValid()) {
			throw new MPIValidationException("Cidadão inválido.", error);
		}

		HashMap<String, Object> variables = new HashMap<>();
		variables.put("requestTime", requestTime);
		variables.put("certidoes", cidadao.getCertidoes());
		variables.put("cnh", cidadao.getCnh());
		variables.put("cnss", cidadao.getCnss());
		variables.put("contatos", cidadao.getContatos());
		variables.put("cpf", cidadao.getCpf());
		variables.put("ctps", cidadao.getCtps());
		variables.put("dataNascimento", cidadao.getDataNascimento());
		variables.put("dataObito", cidadao.getDataObito());
		variables.put("enderecos", cidadao.getEnderecos());
		variables.put("etnia", cidadao.getEtnia());
		variables.put("identificadoresLocais", cidadao.getIdentificadoresLocais());
		variables.put("nacionalidade", cidadao.getNacionalidade());
		variables.put("nome", cidadao.getNome());
		variables.put("nomeMae", ofNullable(cidadao.getNomeMae()).orElse("SEM INFORMAÇÃO"));
		variables.put("nomePai", ofNullable(cidadao.getNomePai()).orElse("SEM INFORMAÇÃO"));
		variables.put("nomeSocial", cidadao.getNomeSocial());
		variables.put("numeroDnv", cidadao.getNumeroDnv());
		variables.put("numeroNisPisPasep", cidadao.getNumeroNisPisPasep());
		variables.put("numeroRic", cidadao.getNumeroRic());
		variables.put("passaportes", cidadao.getPassaportes());
		variables.put("racaCor", cidadao.getRacaCor());
		variables.put("rg", cidadao.getRg());
		variables.put("sexo", cidadao.getSexo());
		variables.put("tipoConfidencialidade", cidadao.getTipoConfidencialidade());
		variables.put("tituloEleitor", cidadao.getTituloEleitor());
		variables.put("vip", cidadao.isVip());
		variables.put("vivo", cidadao.isVivo());

		return new TemplateSerializer().serialize("/templates/PRPA_IN201301UV02.xml", variables);
	}

}
