package br.ufsc.bridge.mpiclient.exceptions;

public class MPIRuntimeException extends RuntimeException {
	public MPIRuntimeException(String message) {
		super(message);
	}

	public MPIRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public MPIRuntimeException(Throwable cause) {
		super(cause);
	}
}
