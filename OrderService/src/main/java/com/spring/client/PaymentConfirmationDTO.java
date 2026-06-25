package com.spring.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentConfirmationDTO {

	private String toMail;
	private Long paymentId;
	private Long orderId;
	private Double amount;
	private String paymentStatus;
}
