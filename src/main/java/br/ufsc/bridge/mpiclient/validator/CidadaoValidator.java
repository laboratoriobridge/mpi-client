package br.ufsc.bridge.mpiclient.validator;

import static br.ufsc.bridge.mpiclient.model.MCidadao.meta;

import br.ufsc.bridge.mpiclient.model.Cidadao;
import br.ufsc.bridge.platform.validation.form.errors.FormError;
import br.ufsc.bridge.platform.validation.rules.Rules;

public class CidadaoValidator {

	private CNSValidator cnsValidator = new CNSValidator();
	private CertidaoValidator certidaoValidator = new CertidaoValidator();
	private ContatoValidator contatoValidator = new ContatoValidator();
	private CNHValidator cnhValidator = new CNHValidator();
	private CTPSValidator ctpsValidator = new CTPSValidator();
	private EnderecoValidator enderecoValidator = new EnderecoValidator();
	private IdentificadorLocalValidator identificadorLocalValidator = new IdentificadorLocalValidator();
	private PassaporteValidator passaporteValidator = new PassaporteValidator();
	private RGValidator rgValidator = new RGValidator();
	private TituloEleitorValidator tituloEleitorValidator = new TituloEleitorValidator();

	public void validate(Cidadao cidadao, FormError error) {
		error
				.check(meta.dataNascimento, Rules.required)
				.check(meta.identificadoresLocais, Rules.required)
				.check(meta.nacionalidade, Rules.required)
				.check(meta.nome, Rules.required)
				.check(meta.racaCor, Rules.required)
				.check(meta.tipoConfidencialidade, Rules.required);

		if (cidadao.getCnss() != null) {
			error.forEach(meta.cnss, this.cnsValidator::validate);
		}
		if (cidadao.getCertidoes() != null) {
			error.forEach(meta.certidoes, this.certidaoValidator::validate);
		}
		if (cidadao.getContatos() != null) {
			error.forEach(meta.contatos, this.contatoValidator::validate);
		}
		if (cidadao.getCnh() != null) {
			this.cnhValidator.validate(cidadao.getCnh(), error.formError(meta.cnh()));
		}
		if (cidadao.getCtps() != null) {
			this.ctpsValidator.validate(cidadao.getCtps(), error.formError(meta.ctps()));
		}
		if (cidadao.getEnderecos() != null) {
			error.forEach(meta.enderecos, this.enderecoValidator::validate);
		}
		if (error.isValid(meta.identificadoresLocais)) {
			error.forEach(meta.identificadoresLocais, this.identificadorLocalValidator::validate);
		}
		if (cidadao.getPassaportes() != null) {
			error.forEach(meta.passaportes, this.passaporteValidator::validate);
		}
		if (cidadao.getRg() != null) {
			this.rgValidator.validate(cidadao.getRg(), error.formError(meta.rg()));
		}
		if (cidadao.getTituloEleitor() != null) {
			this.tituloEleitorValidator.validate(cidadao.getTituloEleitor(), error.formError(meta.tituloEleitor()));
		}
	}

}
