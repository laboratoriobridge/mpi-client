package br.ufsc.bridge.mpiclient.validator;

import static br.ufsc.bridge.mpiclient.model.MPassaporte.meta;

import br.ufsc.bridge.mpiclient.model.Passaporte;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class PassaporteValidator {

	public void validate(Passaporte passaporte, FormError error) {
		error
				.check(meta.dataEmissao, Rules.required)
				.check(meta.dataValidade, Rules.required)
				.check(meta.numero, Rules.required)
				.check(meta.paisOrigem, Rules.required);
	}

}
