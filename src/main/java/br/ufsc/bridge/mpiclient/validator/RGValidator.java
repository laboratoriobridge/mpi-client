package br.ufsc.bridge.mpiclient.validator;

import static br.ufsc.bridge.mpiclient.model.MRG.meta;

import br.ufsc.bridge.mpiclient.model.RG;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class RGValidator {

	public void validate(RG rg, FormError error) {
		error
				.check(meta.dataEmissao, Rules.required)
				.check(meta.numero, Rules.required)
				.check(meta.orgaoEmissor, Rules.required)
				.check(meta.uf, Rules.required);
	}

}
