package br.ufsc.bridge.mpiclient.exceptions;

public class MPISoapException extends MPIException {
	public MPISoapException(String textContent) {
		super(textContent);
	}

	public MPISoapException(String message, Throwable cause) {
		super(message, cause);
	}

	public MPISoapException(Throwable cause) {
		super(cause);
	}
}
