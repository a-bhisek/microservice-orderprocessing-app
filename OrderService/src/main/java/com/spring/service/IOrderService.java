package com.spring.service;

import java.util.List;

import com.spring.vo.OrderRequestVO;
import com.spring.vo.OrderResponseVO;

public interface IOrderService {

	public String placeOrder(OrderRequestVO requestVO);
	public OrderResponseVO getOrderDetails(Long orderId);
	public OrderResponseVO updateOrderStatus();
	public List<OrderResponseVO> getAllOrders();
}
