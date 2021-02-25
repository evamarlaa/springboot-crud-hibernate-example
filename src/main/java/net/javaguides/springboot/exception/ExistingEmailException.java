package net.javaguides.springboot.exception;

public class ExistingEmailException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ExistingEmailException(String message) {
		super(message);
	}
	
	public ExistingEmailException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
