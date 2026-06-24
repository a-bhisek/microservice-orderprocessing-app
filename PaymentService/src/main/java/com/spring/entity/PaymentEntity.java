package com.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="PAYMENT_SERVICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PaymentEntity {

	@Id
	@SequenceGenerator(name="gen1", 
	                   sequenceName = "PAYMENT_SEQUENCE", 
	                   allocationSize = 1, 
	                   initialValue = 1000)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Long paymentId;
	@NonNull
	private Long orderId;
	@NonNull
	private Double amount;
	@NonNull
	private String paymentMode;
	@NonNull
	private String paymentStatus;
	@CreationTimestamp
	private LocalDateTime paymentTime;
}
