package br.ufsc.bridge.mpiclient.validator;

import br.ufsc.bridge.mpiclient.model.CNS;
import br.ufsc.bridge.mpiclient.model.MCNS;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class CNSValidator {

	public void validate(CNS cns, FormError error) {
		error
				.check(MCNS.meta.numero, Rules.required);
	}

}
