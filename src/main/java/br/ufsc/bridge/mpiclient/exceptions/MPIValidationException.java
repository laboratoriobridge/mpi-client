package br.ufsc.bridge.mpiclient.exceptions;

import java.util.HashMap;

import lombok.Getter;

@Getter
public class MPIValidationException extends MPIException {
	private HashMap<String, Object> errors;

	public MPIValidationException(String msg, HashMap<String, Object> errors) {
		super(msg);
		this.errors = errors;
	}

}
