package com.spring.exception;

@SuppressWarnings("serial")
public class PaymentUnsuccessfulException extends Exception {

	public PaymentUnsuccessfulException(String msg) {
		super(msg);
	}
}
