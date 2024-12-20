package com.rimorais.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OutOfRangeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public OutOfRangeException(String message) {
		super(message);
	}
}
