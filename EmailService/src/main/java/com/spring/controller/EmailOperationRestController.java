package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.OrderPlacedDTO;
import com.spring.dto.PaymentConfirmationDTO;
import com.spring.service.IEmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/email-api")
public class EmailOperationRestController {

	@Autowired
	private IEmailService service;
	
	@PostMapping("/sendOrderPlacedMail")
	public ResponseEntity<String> sendOrderPlacedMail(@RequestBody OrderPlacedDTO orderDTO) throws MessagingException{
		String msg = service.sendOrderPlacedMail(orderDTO);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@PostMapping("/sendPaymentConfirmationMail")
	public ResponseEntity<String> sendPaymentConfirmationMail(@RequestBody PaymentConfirmationDTO paymentDTO) throws MessagingException{
		String msg = service.sendPaymentSuccessMail(paymentDTO);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
