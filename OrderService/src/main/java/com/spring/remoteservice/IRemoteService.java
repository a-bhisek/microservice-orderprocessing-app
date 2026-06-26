package com.spring.remoteservice;


import com.spring.client.InventoryResponseVO;
import com.spring.client.OrderPlacedDTO;
import com.spring.client.PaymentConfirmationDTO;
import com.spring.client.PaymentRequestVO;
import com.spring.client.PaymentResponseVO;


public interface IRemoteService {

	public InventoryResponseVO checkAndReduceInventory(Long productId, Integer quantity);
	public PaymentResponseVO makePayment(PaymentRequestVO requestVO);
	public String sendOrderPlacedMail(OrderPlacedDTO dto);
	public String sendPaymentConfirmationMail(PaymentConfirmationDTO dto);
}
