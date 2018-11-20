package br.ufsc.bridge.mpiclient.validator;

import static br.ufsc.bridge.mpiclient.model.MContato.meta;

import br.ufsc.bridge.mpiclient.model.Contato;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class ContatoValidator {

	public void validate(Contato contato, FormError error) {
		error
				.check(meta.tipo, Rules.required)
				.check(meta.value, Rules.required);
	}

}
