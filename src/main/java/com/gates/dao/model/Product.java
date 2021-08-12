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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "barcode", length = 64)
	private String barcode;

	@Column(name = "model_code", length = 64)
	private String modelCode;

	@Column(name = "name", length = 255)
	private String name;

	@Column(name = "quantity")
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturer;

	@Column(name = "price")
	private Double price;

	@Column(name = "retail_price")
	private Double retailPrice;

	@Column(name = "tax_id")
	@Enumerated(EnumType.ORDINAL)
	private Tax tax;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "date_added")
	private Date createdDate;

	@Column(name = "date_modified")
	private Date updatedDate;

	@Column(name = "made_in_turkey")
	private Boolean madeInTurkey;

	@OneToOne(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private ProductDescription productDescription;

	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<ProductImage> productImages;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "product_marketplace", joinColumns = { @JoinColumn(name = "product_id") }, 
               inverseJoinColumns = { @JoinColumn(name = "marketplace_id") })
    List<Marketplace> marketplaces;
	
	@PrePersist
	public void prePersist() {
		setCreatedDate(new Date());
		setUpdatedDate(new Date() );
	}
	
	@PreUpdate
	public void preUpdate() {
		setUpdatedDate(new Date() );
	}

}
