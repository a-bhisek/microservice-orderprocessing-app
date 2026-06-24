package com.spring.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponseVO {

	
	private Long productId;
	private String productName;
	private Double productPrice;
	private Integer stock;
}