package br.ufsc.bridge.mpiclient.validator;

import static br.ufsc.bridge.mpiclient.model.MIdentificadorLocal.meta;

import br.ufsc.bridge.mpiclient.model.IdentificadorLocal;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class IdentificadorLocalValidator {

	public void validate(IdentificadorLocal identificadorLocal, FormError error) {
		error
				.check(meta.idLocal, Rules.required)
				.check(meta.oidSistema, Rules.required);
	}

}
