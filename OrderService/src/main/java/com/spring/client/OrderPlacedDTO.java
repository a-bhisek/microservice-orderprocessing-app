package com.spring.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderPlacedDTO {

	private String toMail;
	private Long orderId;
}
