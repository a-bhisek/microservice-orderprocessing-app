package com.spring.client;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentResponseVO {
	
	private Long paymentId;
	private Long orderId;
	private Double amount;
	private String paymentMode;
	private String paymentStatus;
	private LocalDateTime paymentTime;
}
