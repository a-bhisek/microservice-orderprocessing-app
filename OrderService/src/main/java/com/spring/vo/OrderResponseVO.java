package com.spring.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseVO {

	private Long orderId;
	private Long productId;
	private Integer quantity;
	private Double totalAmount;
	private String status;
	private LocalDateTime creationTime; 
}
