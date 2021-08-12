package com.gates.dao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "manufacturer")
@Data
public class Manufacturer {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "name", length = 255)
	 private String name;
	 
	 @Column(name = "manufacturer_description")
	 private String manufacturerDescription;
	 
	 @OneToMany(mappedBy = "manufacturer" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	 List<Product> products;
	 
	 
}
