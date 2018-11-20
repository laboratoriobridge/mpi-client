package br.ufsc.bridge.mpiclient.exceptions;

public class MPIPixException extends MPIException {
	public MPIPixException(String textContent) {
		super(textContent);
	}

	public MPIPixException(String message, Throwable cause) {
		super(message, cause);
	}

	public MPIPixException(Throwable cause) {
		super(cause);
	}
}
