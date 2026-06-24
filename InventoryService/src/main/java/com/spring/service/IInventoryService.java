package com.spring.service;

import java.util.List;

import com.spring.exceptions.ProductAlreadyExistsException;
import com.spring.exceptions.ProductNotFoundException;
import com.spring.exceptions.ProductOutOfStockException;
import com.spring.vo.InventoryRequestVO;
import com.spring.vo.InventoryResponseVO;

public interface IInventoryService {

	public String addProduct(InventoryRequestVO requestVO) throws ProductAlreadyExistsException;
	public InventoryResponseVO getProduct(Long productId) throws ProductNotFoundException;
	public List<InventoryResponseVO> getAllProducts() throws ProductNotFoundException;
	public InventoryResponseVO checkAndReduceStock(Long productId, Integer quantity) throws ProductNotFoundException, ProductOutOfStockException;
}
