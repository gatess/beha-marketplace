package com.gates.dao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name = "order")
@Data
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "order_number", length = 10)
	private Long orderNumber;
	
	@Column(name = "date_added")
	private Date createDate;

	@Column(name = "date_modified")
	private Date updateDate;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "order_status_id")
	private OrderStatus orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "marketplace_id")
	private Marketplace marketplace;
	
	@Column(name = "comission")
	private Double comission;
	
	@Column(name = "total")
	private Double total;
	
	@Column(name = "comment")
	private String comment;
	
	@OneToMany(mappedBy = "order",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails;
	
	
}
