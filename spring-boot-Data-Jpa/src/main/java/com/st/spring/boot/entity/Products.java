package com.st.spring.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "product_code")
	private String productCode;
	@Column(name = "product_name")
	private String productName;
	private Integer quantity;
	private Double price;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "product_desc")
	private String productDesc;
}
