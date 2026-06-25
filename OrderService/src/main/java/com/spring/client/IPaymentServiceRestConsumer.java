package com.spring.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PaymentService")
public interface IPaymentServiceRestConsumer {

	@PostMapping("/payment-api/makePayment")
	public PaymentResponseVO makePayment(@RequestBody PaymentRequestVO requestVO);
	
	@GetMapping("/payment-api/findPayment/{paymentId}")
	public PaymentResponseVO getPaymentDetails(@PathVariable Long paymentId);
}
