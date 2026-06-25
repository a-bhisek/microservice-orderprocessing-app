package com.spring.service;

import java.util.List;

import com.spring.exception.OrderIdNotFoundException;
import com.spring.exception.OrderUnsuccessfulException;
import com.spring.exception.OrdersEmptyException;
import com.spring.exception.PaymentUnsuccessfulException;
import com.spring.vo.OrderRequestVO;
import com.spring.vo.OrderResponseVO;

public interface IOrderService {

	public String placeOrder(OrderRequestVO requestVO)throws OrderUnsuccessfulException, PaymentUnsuccessfulException;
	public OrderResponseVO getOrderDetails(Long orderId)throws OrderIdNotFoundException;
	public OrderResponseVO updateOrderStatus(Long orderId, String status) throws OrderIdNotFoundException;
	public List<OrderResponseVO> getAllOrders()throws OrdersEmptyException;
}
