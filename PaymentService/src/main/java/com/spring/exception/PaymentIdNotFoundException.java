package com.spring.exception;

@SuppressWarnings("serial")
public class PaymentIdNotFoundException extends Exception {

	public PaymentIdNotFoundException(String msg) {
		super(msg);
	}
}
