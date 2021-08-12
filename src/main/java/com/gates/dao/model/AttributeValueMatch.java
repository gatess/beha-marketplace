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
@Table(name = "attribute_value_match")
@Data
public class AttributeValueMatch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="product_attribute_id")
	private ProductAttribute productAttribute;
	
	@Column(name="product_attribute_value_id")
	private ProductAttributeValue productAttributeValue;
	
	@Column(name="product_attribute_value_text")
	private String productAttributeValueText;

}
