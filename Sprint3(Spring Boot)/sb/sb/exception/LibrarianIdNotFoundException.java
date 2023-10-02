package com.library.sb.exception;

public class LibrarianIdNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public LibrarianIdNotFoundException(String message) {
		super(message);

	}
}