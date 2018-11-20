package br.ufsc.bridge.mpiclient.validator;

import static br.ufsc.bridge.mpiclient.model.MCTPS.meta;

import br.ufsc.bridge.mpiclient.model.CTPS;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class CTPSValidator {

	public void validate(CTPS ctps, FormError error) {
		error
				.check(meta.dataEmissao, Rules.required)
				.check(meta.numero, Rules.required)
				.check(meta.serie, Rules.required);
	}

}
