package com.spring.remoteservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.client.IEmailServiceRestConsumer;
import com.spring.client.IInventoryServiceRestConsumer;
import com.spring.client.IPaymentServiceRestConsumer;
import com.spring.client.InventoryResponseVO;
import com.spring.client.OrderPlacedDTO;
import com.spring.client.PaymentConfirmationDTO;
import com.spring.client.PaymentRequestVO;
import com.spring.client.PaymentResponseVO;
import com.spring.exception.OrderUnsuccessfulException;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Component
public class RemoteServiceImpl implements IRemoteService {
	
	@Autowired
	private IInventoryServiceRestConsumer inventoryConsumer;
	
	@Autowired
	private IPaymentServiceRestConsumer paymentConsumer;
	
	@Autowired
	private IEmailServiceRestConsumer emailConsumer;

	@Override
	@CircuitBreaker(name="inventoryCircuitBreaker", fallbackMethod = "inventoryFallback")
	public InventoryResponseVO checkAndReduceInventory(Long productId, Integer quantity) {
		
		return inventoryConsumer.checkAndReduceStock(productId,quantity);
	}
	
	public InventoryResponseVO inventoryFallback(Long productId, Integer quantity, Exception e) throws OrderUnsuccessfulException {
		
		System.out.println(e.getMessage());
	    
		 throw new OrderUnsuccessfulException("Inventory Service is unavailable.");
	}

	@Override
	@CircuitBreaker(name="paymentCircuitBreaker", fallbackMethod = "paymentFallBack")
	public PaymentResponseVO makePayment(PaymentRequestVO requestVO) {
		
		return paymentConsumer.makePayment(requestVO);
	}
	
	 public PaymentResponseVO paymentFallBack(PaymentRequestVO requestVO, Exception e) throws OrderUnsuccessfulException {

			System.out.println(e.getMessage());

			throw new OrderUnsuccessfulException("Inventory Service is unavailable.");
    }

	@Override
	@CircuitBreaker(name="emailCircuitBreaker", fallbackMethod = "orderMailFallback")
	public String sendOrderPlacedMail(OrderPlacedDTO dto) {
		
		return emailConsumer.sendOrderPlacedMail(dto);
	}
	
	public String orderMailFallback(OrderPlacedDTO dto, Exception e) {

		System.out.println(e.getMessage());
		
		return "Order mail could not be sent.";

	}

	@Override
	@CircuitBreaker(name="emailCircuitBreaker", fallbackMethod = "paymentMailFallback")
	public String sendPaymentConfirmationMail(PaymentConfirmationDTO dto) {
		
		return emailConsumer.sendPaymentConfirmationMail(dto);
	}
	
	public String paymentMailFallback(PaymentConfirmationDTO dto, Exception e) {
		
		System.out.println(e.getMessage());
		
		return "Payment mail could not be sent.";
	}

}
