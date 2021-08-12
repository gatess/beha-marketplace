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
@Table(name = "category")
@Data
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Product> products;
	
	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<CategoryMatch> categoryMatchs;
	
	
}
