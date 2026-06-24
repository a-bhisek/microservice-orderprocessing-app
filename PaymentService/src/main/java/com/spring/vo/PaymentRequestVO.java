package com.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentRequestVO {

	private Long orderId;
	private Double amount;
	private String paymentMode;
}
