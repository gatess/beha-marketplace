package com.gates.dao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "marketplace")
@Data
public class Marketplace {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "name", length = 255)
	 private String name;
	 
	 @OneToMany(mappedBy = "marketplace" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	 List<Order> orders;
	 
	 @OneToMany(mappedBy = "marketplace" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	 List<Customer> customers;
	 
	 @OneToMany(mappedBy = "category" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	 List<CategoryMatch> categoryMatchs;
	 
	 @ManyToMany(mappedBy = "marketplaces")
	 private List<Product> products;

}
