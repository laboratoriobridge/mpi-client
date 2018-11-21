package br.ufsc.bridge.mpiclient.exceptions;

public class MPIXmlParseException extends MPIException {
	public MPIXmlParseException(String textContent) {
		super(textContent);
	}

	public MPIXmlParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public MPIXmlParseException(Throwable cause) {
		super(cause);
	}
}
