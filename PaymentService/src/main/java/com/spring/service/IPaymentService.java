package com.spring.service;

import com.spring.exception.PaymentFailedException;
import com.spring.exception.PaymentIdNotFoundException;
import com.spring.vo.PaymentRequestVO;
import com.spring.vo.PaymentResponseVO;

public interface IPaymentService {

	public PaymentResponseVO makePayment(PaymentRequestVO requestVO)throws PaymentFailedException;
	public PaymentResponseVO getPaymentDetails(Long paymentId)throws PaymentIdNotFoundException;
	
}
