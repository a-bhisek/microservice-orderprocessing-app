package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.ProductEntity;
import com.spring.exceptions.ProductAlreadyExistsException;
import com.spring.exceptions.ProductNotFoundException;
import com.spring.exceptions.ProductOutOfStockException;
import com.spring.repository.ProductRepository;
import com.spring.vo.InventoryRequestVO;
import com.spring.vo.InventoryResponseVO;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class InventoryServiceImpl implements IInventoryService {

	@Autowired
	private ProductRepository prodRepo;
	
	@Override
	public String addProduct(InventoryRequestVO requestVO) throws ProductAlreadyExistsException {
		String productName = requestVO.getProductName();
		if(prodRepo.findByProductNameIgnoreCase(productName) != null){
			throw new  ProductAlreadyExistsException("Product already exists");
		}
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(requestVO, productEntity);
		System.out.println(productEntity);
		Long id = prodRepo.save(productEntity).getProductId();
		log.info("Product added successfully");
		return "Product added successfully having product id : "+id;
		
	}

	@Override
	public InventoryResponseVO getProduct(Long productId) throws ProductNotFoundException{
		ProductEntity productEntity = prodRepo.findById(productId)
				                              .orElseThrow(()->
				                               new ProductNotFoundException("Product having product id "+productId+" not found"));
		InventoryResponseVO responseVO = new InventoryResponseVO();
		BeanUtils.copyProperties(productEntity, responseVO);
		log.info("Product find");
		return responseVO;
	}

	@Override
	public List<InventoryResponseVO> getAllProducts() throws ProductNotFoundException {
		List<ProductEntity> products = prodRepo.findAll();
		if(products.isEmpty()) {
			throw new ProductNotFoundException("Products are not available right now");
		}
			List<InventoryResponseVO> listResponseVO = new ArrayList<>();
			products.forEach(productEntity ->{
			InventoryResponseVO responseVO = new InventoryResponseVO();
			BeanUtils.copyProperties(productEntity, responseVO);
			listResponseVO.add(responseVO);
		});
		return listResponseVO;
	}

	@Override
	public InventoryResponseVO checkAndReduceStock(Long productId, Integer quantity) throws ProductNotFoundException, ProductOutOfStockException {
		ProductEntity productEntity = prodRepo.findById(productId)
                .orElseThrow(()->
                 new ProductNotFoundException("Product having product id "+productId+" not found"));
        if(productEntity.getStock() < quantity) throw new ProductOutOfStockException("Product Currently Out Of Stock");
        productEntity.setStock(productEntity.getStock() - quantity);
		prodRepo.save(productEntity);
		InventoryResponseVO responseVO = new InventoryResponseVO();
		BeanUtils.copyProperties(productEntity, responseVO);
		log.info("Product is in stock and reduced");
		return responseVO;
	}


}
