package com.spring.exception;

@SuppressWarnings("serial")
public class OrderIdNotFoundException extends Exception {

	public OrderIdNotFoundException(String msg){
		super(msg);
	}
}
