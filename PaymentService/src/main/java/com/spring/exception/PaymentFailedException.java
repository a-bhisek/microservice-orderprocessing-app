package com.spring.exception;

@SuppressWarnings("serial")
public class PaymentFailedException extends Exception {

	public PaymentFailedException(String msg) {
		super(msg);
	}
}
