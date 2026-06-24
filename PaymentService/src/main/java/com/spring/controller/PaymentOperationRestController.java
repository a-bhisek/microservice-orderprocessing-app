package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.PaymentFailedException;
import com.spring.exception.PaymentIdNotFoundException;
import com.spring.service.IPaymentService;
import com.spring.vo.PaymentRequestVO;
import com.spring.vo.PaymentResponseVO;

@RestController
@RequestMapping("/payment-api")
public class PaymentOperationRestController {
	
	@Autowired
	private IPaymentService service;

	@PostMapping("/makePayment")
	public ResponseEntity<PaymentResponseVO> makePayment(@RequestBody PaymentRequestVO requestVO) throws PaymentFailedException{
		PaymentResponseVO responseVO = service.makePayment(requestVO);
		return new ResponseEntity<PaymentResponseVO>(responseVO,HttpStatus.CREATED);
	}
	
	@GetMapping("/findPayment/{paymentId}")
	public ResponseEntity<PaymentResponseVO> getPaymentDetails(@PathVariable Long paymentId) throws PaymentIdNotFoundException{
		PaymentResponseVO responseVO = service.getPaymentDetails(paymentId);
		return ResponseEntity.ok(responseVO);
	}
}
