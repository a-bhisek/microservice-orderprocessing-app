package com.spring.exceptions;


@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception {

	public ProductNotFoundException(String msg) {
		super(msg);
	}

}
