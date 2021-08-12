package com.gates.dao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "customer")
@Data
public class Customer {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "name", length = 255)
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "date_added")
	private Date createDate;

	@Column(name = "date_modified")
	private Date updateDate;
	
	@OneToMany(mappedBy = "customer" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Address> address;
	
	 @OneToMany(mappedBy = "customer" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	 List<Order> orders;
	
	
}
