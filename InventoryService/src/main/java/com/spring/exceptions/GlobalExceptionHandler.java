package com.spring.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.entity.ErrorDetails;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> handleProductAlreadyExist(ProductAlreadyExistsException pae){
		ErrorDetails details = new ErrorDetails(
				               LocalDateTime.now(),
				               404,
				               pae.getMessage()
				);
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> handelProductNotFound(ProductNotFoundException pnef){
		ErrorDetails details = new ErrorDetails(
	               LocalDateTime.now(),
	               404,
	               pnef.getMessage()
	);
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ProductOutOfStockException.class)
	public ResponseEntity<ErrorDetails> handelProductOutOfStock(ProductOutOfStockException pose){
		ErrorDetails details = new ErrorDetails(
	               LocalDateTime.now(),
	               404,
	               pose.getMessage()
	);
       return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handelException(Exception e){
		ErrorDetails details = new ErrorDetails(
	               LocalDateTime.now(),
	               404,
	               e.getMessage()
	);
	   return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
