package com.gates.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product_description")
@Data
public class ProductDescription {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
		
	   @OneToOne(fetch=FetchType.LAZY)
	   @JoinColumn(name="product_id")
	   private Product product;
	
	   @Column(name = "description")
	   private String description;

	   @Column(name = "tag")
	   private String tag;

	   @Column(name = "meta_title")
	   private String metaTitle;

	   @Column(name = "meta_description")
	   private String metaDescription;

	   @Column(name = "meta_keyword")
	   private String metaKeyword;

}
