package com.gates.dao.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "category_match")
@Data
public class CategoryMatch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "marketplace_id")
	private Marketplace marketplace;
	
	@Column(name = "marketplace_category_id")
	private Long marketplaceCategoryId;
	
	@OneToMany(mappedBy = "categoryMatch",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private ProductAttribute productAttribute;
	
	

}
