package br.com.sgeescala.util;

public class UtilException extends Exception {

//	private static final long serialVersionUID = 4621699577869994806L;

//	private static final long serialVersionUID = 1L;

	private static final long serialVersionUID = -7888029283759931165L;

	public UtilException() {
	}

	public UtilException(String message) {
		super(message);
	}

	public UtilException(Throwable cause) {
		super(cause);
	}

	public UtilException(String message, Throwable cause) {
		super(message, cause);
	}

	public UtilException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
