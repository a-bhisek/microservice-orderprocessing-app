package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.OrderUnsuccessfulException;
import com.spring.service.IOrderService;
import com.spring.vo.OrderRequestVO;

@RestController
@RequestMapping("/order-api")
public class OrderOperationsRestController {

	@Autowired
	private IOrderService service;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<String> placeOrder(@RequestBody OrderRequestVO requestVO) throws OrderUnsuccessfulException{
		String msg = service.placeOrder(requestVO);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
}
