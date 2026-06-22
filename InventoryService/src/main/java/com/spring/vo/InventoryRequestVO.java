package com.spring.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRequestVO {

	private String productName;
	private Double productPrice;
	private Integer stock;
}
