package br.ufsc.bridge.mpiclient.validator;

import br.ufsc.bridge.mpiclient.model.Certidao;
import br.ufsc.bridge.mpiclient.model.CertidaoAntiga;
import br.ufsc.bridge.mpiclient.model.CertidaoNova;
import br.ufsc.bridge.mpiclient.model.MCertidaoAntiga;
import br.ufsc.bridge.mpiclient.model.MCertidaoNova;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class CertidaoValidator {

	public void validate(Certidao certidao, FormError error) {
		if (certidao instanceof CertidaoAntiga) {
			error
					.check(MCertidaoAntiga.meta.cartorio, Rules.required)
					.check(MCertidaoAntiga.meta.dataEmissao, Rules.required)
					.check(MCertidaoAntiga.meta.folha, Rules.required)
					.check(MCertidaoAntiga.meta.livro, Rules.required)
					.check(MCertidaoAntiga.meta.termo, Rules.required)
					.check(MCertidaoAntiga.meta.tipo, Rules.required);
		} else if (certidao instanceof CertidaoNova) {
			error
					.check(MCertidaoNova.meta.dataEmissao, Rules.required)
					.check(MCertidaoNova.meta.matricula, Rules.required)
					.check(MCertidaoNova.meta.tipo, Rules.required);
		}
	}

}
