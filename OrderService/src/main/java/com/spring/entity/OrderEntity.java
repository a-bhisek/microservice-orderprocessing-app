package com.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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
@Table(name="ORDER_SERVICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderEntity {

	@Id
	@SequenceGenerator(name = "order",
	                   sequenceName = "ORDER_SEQUENCE",
	                   allocationSize = 1,
	                   initialValue = 100001)
	@GeneratedValue(generator = "order",strategy = GenerationType.SEQUENCE)
	private Long orderId;
	@NonNull
	private Long productId;
	@NonNull
	private Integer quantity;
	@NonNull
	private Double totalAmount;
	@NonNull
	private String status = "PROCESSING";
	
	//MetaData Properties
	private String createdBy = System.getProperty("user.name");
	@CreationTimestamp
	@Column(insertable = true, updatable = false)
	private LocalDateTime creationTime;
	@Column(insertable=false, updatable = true)
	private String updatedBy = System.getProperty("user.name");
	@UpdateTimestamp
	@Column(insertable=true, updatable = true)
	private LocalDateTime updationTime;
}
