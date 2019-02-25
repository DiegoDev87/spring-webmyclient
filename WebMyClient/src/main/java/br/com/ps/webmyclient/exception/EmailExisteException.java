package br.com.ps.webmyclient.exception;

@SuppressWarnings("serial")
public class EmailExisteException extends Exception {

	public EmailExisteException(String msg) {
		super(msg);
	}

	public EmailExisteException(String msg, Throwable ex) {
		super(msg, ex);
	}

}
