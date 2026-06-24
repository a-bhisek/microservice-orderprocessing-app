package com.spring.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.entity.PaymentEntity;
import com.spring.exception.PaymentFailedException;
import com.spring.exception.PaymentIdNotFoundException;
import com.spring.repository.PaymentRepository;
import com.spring.vo.PaymentRequestVO;
import com.spring.vo.PaymentResponseVO;

public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private PaymentRepository paymentRepo;
	
	@Override
	public PaymentResponseVO makePayment(PaymentRequestVO requestVO) throws PaymentFailedException {
		PaymentEntity paymentEntity = new PaymentEntity();
		BeanUtils.copyProperties(requestVO, paymentEntity);
		paymentEntity.setPaymentStatus("SUCCESS");
		PaymentEntity savedEntity = paymentRepo.save(paymentEntity);
		PaymentResponseVO responseVO = new PaymentResponseVO();
		BeanUtils.copyProperties(savedEntity, responseVO);
		return responseVO;
	}

	@Override
	public PaymentResponseVO getPaymentDetails(Long paymentId) throws PaymentIdNotFoundException {
		PaymentEntity paymentEntity = paymentRepo.findById(paymentId)
				                                 .orElseThrow(()->new PaymentIdNotFoundException("Payment details not found having payment id : "+paymentId));
		PaymentResponseVO responseVO = new PaymentResponseVO();
		BeanUtils.copyProperties(paymentEntity, responseVO);
		return responseVO;
	}

}
