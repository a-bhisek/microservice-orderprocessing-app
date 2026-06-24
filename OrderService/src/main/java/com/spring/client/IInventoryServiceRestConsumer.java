package com.spring.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("InventoryService")
public interface IInventoryServiceRestConsumer {

	@PutMapping("/inventory-api/checkAndReduceStock/{productId}/{quantity}")
	public InventoryResponseVO checkAndReduceStock(@PathVariable Long productId, @PathVariable Integer quantity);
	
}
