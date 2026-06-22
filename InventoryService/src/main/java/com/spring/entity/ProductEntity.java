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
@Table(name="INVENTORY_SERVICE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductEntity {

	@Id
	@SequenceGenerator(name="inventory",
	                   sequenceName = "INVENTORY_SEQUENCE", 
	                   allocationSize = 1, 
	                   initialValue = 101)
	@GeneratedValue(generator = "inventory", strategy = GenerationType.SEQUENCE)
	private Long productId;
	@NonNull
	private String productName;
	@NonNull
	private Double productPrice;
	@NonNull
	private Integer stock;
	
	//MetaData Properties
	private String createdBy = System.getProperty("user.name");
	private String updatedBy = System.getProperty("user.name");
	@CreationTimestamp
	@Column(insertable=true, updatable=false)
	private LocalDateTime creationTime;
	@UpdateTimestamp
	@Column(insertable=true, updatable=true)
	private LocalDateTime updationTime;
}
