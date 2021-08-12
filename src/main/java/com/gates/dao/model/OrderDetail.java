package com.gates.dao.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "order_detail")
@Data
public class OrderDetail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
 
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
	
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private int price;
	
	
	
	
	
	

}
