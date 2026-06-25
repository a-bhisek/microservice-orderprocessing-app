package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.client.IEmailServiceRestConsumer;
import com.spring.client.IInventoryServiceRestConsumer;
import com.spring.client.IPaymentServiceRestConsumer;
import com.spring.client.InventoryResponseVO;
import com.spring.client.OrderPlacedDTO;
import com.spring.client.PaymentConfirmationDTO;
import com.spring.client.PaymentRequestVO;
import com.spring.client.PaymentResponseVO;
import com.spring.entity.OrderEntity;
import com.spring.exception.OrderIdNotFoundException;
import com.spring.exception.OrderUnsuccessfulException;
import com.spring.exception.OrdersEmptyException;
import com.spring.exception.PaymentUnsuccessfulException;
import com.spring.repository.OrderRepository;
import com.spring.vo.OrderRequestVO;
import com.spring.vo.OrderResponseVO;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IInventoryServiceRestConsumer inventoryConsumer;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private IPaymentServiceRestConsumer paymentConsumer;
	
	@Autowired
	private IEmailServiceRestConsumer emailConsumer;
	
	@Override
	public String placeOrder(OrderRequestVO requestVO) throws OrderUnsuccessfulException, PaymentUnsuccessfulException {
		InventoryResponseVO responseVO = inventoryConsumer.checkAndReduceStock(requestVO.getProductId(),requestVO.getQuantity());
		if(responseVO == null) throw new OrderUnsuccessfulException("There is a problem occours please try after sometime");
		OrderEntity orderEntity = new OrderEntity(); 
		BeanUtils.copyProperties(requestVO, orderEntity);
		orderEntity.setTotalAmount(responseVO.getProductPrice() * orderEntity.getQuantity());
		Long id = orderRepo.save(orderEntity).getOrderId();
		OrderPlacedDTO orderPlacedDTO = new OrderPlacedDTO();
		orderPlacedDTO.setOrderId(id);
		orderPlacedDTO.setToMail("abhisekmohapatra093@gmail.com");
		emailConsumer.sendOrderPlacedMail(orderPlacedDTO);
		PaymentRequestVO paymentRequestVO = new PaymentRequestVO();
		paymentRequestVO.setOrderId(id);
		paymentRequestVO.setAmount(orderEntity.getTotalAmount());
		paymentRequestVO.setPaymentMode("UPI");
		PaymentResponseVO paymentResponseVO = paymentConsumer.makePayment(paymentRequestVO);
		if(paymentResponseVO != null) {
			orderEntity.setStatus("PLACED");
			orderRepo.save(orderEntity);
		PaymentConfirmationDTO paymentDTO = new PaymentConfirmationDTO();
		paymentDTO.setAmount(paymentResponseVO.getAmount());
		paymentDTO.setOrderId(id);
		paymentDTO.setPaymentId(paymentResponseVO.getPaymentId());
		paymentDTO.setPaymentStatus(paymentResponseVO.getPaymentStatus());
		paymentDTO.setToMail("abhisekmohapatra093@gmail.com");
	    emailConsumer.sendPaymentConfirmationMail(paymentDTO);
		return "Order placed Successfully having order id : "+id;
		}
		 orderEntity.setStatus("PAYMENT_FAILED");
		 orderRepo.save(orderEntity);
		 throw new PaymentUnsuccessfulException("Payment Failed");
	}

	@Override
	public OrderResponseVO getOrderDetails(Long orderId)throws OrderIdNotFoundException {
		OrderEntity orderEntity = orderRepo.findById(orderId)
				                           .orElseThrow(()->new OrderIdNotFoundException("Order not found having order id : "+orderId));
		OrderResponseVO responseVO = new OrderResponseVO();
		BeanUtils.copyProperties(orderEntity, responseVO);
		return responseVO;
	}

	@Override
	public OrderResponseVO updateOrderStatus(Long orderId, String status) throws OrderIdNotFoundException {
		OrderEntity orderEntity = orderRepo.findById(orderId)
                                           .orElseThrow(()->new OrderIdNotFoundException("Order not found having order id : "+orderId));
		orderEntity.setStatus(status);
		orderRepo.save(orderEntity);
        OrderResponseVO responseVO = new OrderResponseVO();
        BeanUtils.copyProperties(orderEntity, responseVO);
        return responseVO;
	}

	@Override
	public List<OrderResponseVO> getAllOrders() throws OrdersEmptyException {
	    List<OrderEntity> l = orderRepo.findAll();
	    List<OrderResponseVO> listResponses = new ArrayList<>();
	    if(l.isEmpty()) throw new OrdersEmptyException("No Orders are available");
	    l.forEach(response -> {
	    	OrderResponseVO vo = new OrderResponseVO();
	    	BeanUtils.copyProperties(response, vo);
	    	listResponses.add(vo);
	    });
		return listResponses;
	}

}
