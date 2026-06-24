package com.spring.exception;

@SuppressWarnings("serial")
public class OrdersEmptyException extends Exception {

	public OrdersEmptyException(String msg){
		super(msg);
	}
}
