package com.spring.exceptions;

@SuppressWarnings("serial")
public class ProductAlreadyExistsException extends Exception {
	
	public ProductAlreadyExistsException(String msg) {
		super(msg);
	}

}
