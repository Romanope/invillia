package com.invillia.acme.exceptions;

public class BusinessException extends Exception {

	public BusinessException (String message, Throwable e) {
		super(message, e);
	}

	public BusinessException (String message) {
		super(message);
	}

	public BusinessException () {
		super("Error detected in business rule");
	}
}
