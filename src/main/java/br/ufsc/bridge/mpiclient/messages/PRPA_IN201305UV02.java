package br.ufsc.bridge.mpiclient.messages;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

import br.ufsc.bridge.mpiclient.api.PDQParameters;
import br.ufsc.bridge.mpiclient.exceptions.MPIValidationException;
import br.ufsc.bridge.mpiclient.thymeleaf.TemplateSerializer;

public class PRPA_IN201305UV02 {

	public String create(PDQParameters parameters, LocalDateTime requestTime) throws MPIValidationException {
		HashMap<String, Object> variables = new HashMap<>();
		variables.put("requestTime", requestTime);
		variables.put("cns", parameters.getCns());
		variables.put("codigoMunicipioNascimento", parameters.getCodigoMunicipioNascimento());
		variables.put("cpf", parameters.getCpf());
		variables.put("dataNascimento", parameters.getDataNascimento());
		variables.put("idLocal", parameters.getIdLocal());
		variables.put("nome", parameters.getNome());
		variables.put("nomeMae", parameters.getNomeMae());
		variables.put("numeroPisPasep", parameters.getNumeroNisPisPasep());
		variables.put("oidLocal", Optional.ofNullable(parameters.getOidSistema()).orElse("2.16.840.1.113883.3.4594.100.3"));
		variables.put("sexo", parameters.getSexo());

		return new TemplateSerializer().serialize("/templates/PRPA_IN201305UV02.xml", variables);
	}

}
