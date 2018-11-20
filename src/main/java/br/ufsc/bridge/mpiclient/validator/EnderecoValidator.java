package br.ufsc.bridge.mpiclient.validator;

import static br.ufsc.bridge.mpiclient.model.MEndereco.meta;

import br.ufsc.bridge.mpiclient.model.Endereco;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class EnderecoValidator {

	public void validate(Endereco endereco, FormError error) {
		error
				.check(meta.bairro, Rules.required)
				.check(meta.codigoMunicipio, Rules.required)
				.check(meta.logradouro, Rules.required)
				.check(meta.numero, Rules.required)
				.check(meta.pais, Rules.required)
				.check(meta.tipoLogradouro, Rules.required)
				.check(meta.uf, Rules.required);
	}

}
