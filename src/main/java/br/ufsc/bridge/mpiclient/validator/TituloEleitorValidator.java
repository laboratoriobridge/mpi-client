package br.ufsc.bridge.mpiclient.validator;

import static br.ufsc.bridge.mpiclient.model.MTituloEleitor.meta;

import br.ufsc.bridge.mpiclient.model.TituloEleitor;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class TituloEleitorValidator {

	public void validate(TituloEleitor tituloEleitor, FormError error) {
		error
				.check(meta.numero, Rules.required)
				.check(meta.secao, Rules.required);
	}

}
