package com.spring.exception;

@SuppressWarnings("serial")
public class OrderUnsuccessfulException extends Exception {

	public OrderUnsuccessfulException(String msg){
		super(msg);
	}
}
