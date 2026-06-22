package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exceptions.ProductAlreadyExistsException;
import com.spring.exceptions.ProductNotFoundException;
import com.spring.exceptions.ProductOutOfStockException;
import com.spring.service.IInventoryService;
import com.spring.vo.InventoryRequestVO;
import com.spring.vo.InventoryResponseVO;

@RestController
@RequestMapping("/inventory-api")
public class InventoryOperationController {

	@Autowired
	private IInventoryService service;
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody InventoryRequestVO requestVO) throws ProductAlreadyExistsException{
		String msg = service.addProduct(requestVO);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/findProduct/{productId}")
	public ResponseEntity<InventoryResponseVO> getProduct(@PathVariable Long productId) throws ProductNotFoundException{
		InventoryResponseVO responseVO = service.getProduct(productId);
		return  ResponseEntity.ok(responseVO);
	}
	
	@GetMapping("/findAllProducts")
	public ResponseEntity<List<InventoryResponseVO>> getAllProducts() throws ProductNotFoundException{
		List<InventoryResponseVO> listProducts = service.getAllProducts();
		return ResponseEntity.ok(listProducts);
	}
	
	@PutMapping("/checkAndReduceStock/{productId}/{quantity}")
	public void checkAndReduceStock(@PathVariable Long productId, @PathVariable Integer quantity) throws ProductNotFoundException, ProductOutOfStockException{
		service.checkAndReduceStock(productId, quantity);
	}
}
