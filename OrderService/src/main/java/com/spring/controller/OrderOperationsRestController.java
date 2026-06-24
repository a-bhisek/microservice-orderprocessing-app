package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.OrderIdNotFoundException;
import com.spring.exception.OrderUnsuccessfulException;
import com.spring.exception.OrdersEmptyException;
import com.spring.service.IOrderService;
import com.spring.vo.OrderRequestVO;
import com.spring.vo.OrderResponseVO;

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
	
	@GetMapping("/findOrder/{orderId}")
	public ResponseEntity<OrderResponseVO> getOrderDetails(@PathVariable Long orderId)throws OrderIdNotFoundException {
		OrderResponseVO responseVO = service.getOrderDetails(orderId);
		return ResponseEntity.ok(responseVO);
	}
	
	@PutMapping("/updateOrder/{orderId}/{status}")
	public ResponseEntity<OrderResponseVO> updateOrderStatus(@PathVariable Long orderId, @PathVariable String status) throws OrderIdNotFoundException{
		OrderResponseVO responseVO = service.updateOrderStatus(orderId, status);
		return ResponseEntity.ok(responseVO);
	}
	
	@GetMapping("/findAllOrders")
	public ResponseEntity<List<OrderResponseVO>> getAllOrders() throws OrdersEmptyException{
		List<OrderResponseVO> listResponseVO = service.getAllOrders();
		return ResponseEntity.ok(listResponseVO);
	}
}
