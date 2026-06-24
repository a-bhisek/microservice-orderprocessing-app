package com.spring.service;

import com.spring.dto.OrderPlacedDTO;
import com.spring.dto.PaymentConfirmationDTO;

import jakarta.mail.MessagingException;

public interface IEmailService {

	public String sendOrderPlacedMail(OrderPlacedDTO orderDTO) throws MessagingException;
	public String sendPaymentSuccessMail(PaymentConfirmationDTO paymentDTO) throws MessagingException;
}
