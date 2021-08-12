package com.gates.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product_attribute_value")
@Data
public class ProductAttributeValue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", length = 255)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="product_attribute_id")
	private ProductAttribute productAttribute;
	
	@Column(name = "value_id_from_marketplace")
	private String ValueIdFromMarketplace;
	
}
