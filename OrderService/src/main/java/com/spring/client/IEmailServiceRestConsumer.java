package com.spring.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("EmailService")
public interface IEmailServiceRestConsumer {

	@PostMapping("/email-api/sendOrderPlacedMail")
	public String sendOrderPlacedMail(@RequestBody OrderPlacedDTO orderPlaceDTO);
	
	@GetMapping("/email-api/sendPaymentConfirmationMail")
	public String sendPaymentConfirmationMail(@RequestBody PaymentConfirmationDTO paymentDTO);
}
