package br.ufsc.bridge.mpiclient.validator;

import static br.ufsc.bridge.mpiclient.model.MCNH.meta;

import br.ufsc.bridge.mpiclient.model.CNH;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class CNHValidator {

	public void validate(CNH cnh, FormError error) {
		error
				.check(meta.dataEmissao, Rules.required)
				.check(meta.numero, Rules.required)
				.check(meta.uf, Rules.required);
	}

}
