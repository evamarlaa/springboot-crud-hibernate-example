package net.javaguides.springboot.exception;

public class ExpiredTokenException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExpiredTokenException(String message) {
		super(message);
	}
	
	public ExpiredTokenException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
