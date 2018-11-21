package br.ufsc.bridge.mpiclient.exceptions;

public class MPIException extends Exception {
	public MPIException(String message) {
		super(message);
	}

	public MPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public MPIException(Throwable cause) {
		super(cause);
	}
}
