package br.ufsc.bridge.mpiclient.exceptions;

import lombok.Getter;

import br.ufsc.bridge.platform.validation.form.errors.FormError;

@Getter
public class MPIValidationException extends MPIException {
	private final FormError errors;

	public MPIValidationException(String msg, FormError errors) {
		super(msg);
		this.errors = errors;
	}

}
