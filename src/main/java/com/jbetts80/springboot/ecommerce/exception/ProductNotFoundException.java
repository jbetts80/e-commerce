package com.jbetts80.springboot.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8536461036417842311L;

	public ProductNotFoundException(String message) {
		super(message);
	}

}
