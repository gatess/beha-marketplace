package com.gates.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "special_price")
@Data
public class SpecialPrice {

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	   
	   @ManyToOne
	   @JoinColumn(name="product_id")
	   private Product product;
	   
	   @Column(name = "status")
	   private Boolean status;
	   
	   @Column(name = "price")
	   private Double price;
	   
	   @Column(name = "date_start")
	   private Date dateStart;

	   @Column(name = "date_end")
	   private Date dateEnd;
	   
	   @ManyToOne
	   @JoinColumn(name="marketplace_id")
	   private Marketplace marketplace;
}
