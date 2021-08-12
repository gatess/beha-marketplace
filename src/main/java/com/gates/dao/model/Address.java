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
@Table(name = "address")
@Data
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="address_name")
	private String addressName;
	
	@Column(name="address_description")
	private String addressDescription;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "county")
	private String county;
	
	@Column(name = "zipCode")
	private String zipCode;
	
	@Column(name = "telephone",length = 11)
	private String telephone;
	
	@ManyToOne
	//@NotNull
	@JoinColumn(name = "customer_id")
	private Customer customer;
	

}
