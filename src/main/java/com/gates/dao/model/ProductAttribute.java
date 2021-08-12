
package com.gates.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product_attribute")
@Data
public class ProductAttribute {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", length = 255)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "category_match_id")
	private CategoryMatch categoryMatch;
	
	@Column(name = "required")
	private Boolean required;
	
	@Column(name = "type")
	@Enumerated(EnumType.ORDINAL)
	private ProductAttributeType attributeType;
	
	@Column(name = "attribute_id_from_marketplace")
	private String AttributeIdFromMarketplace;
	
	@OneToMany
	private ProductAttributeValue productAttributeValue;

}
