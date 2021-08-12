package com.gates.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gates.controller.response.GeneralResponse;
import com.gates.dao.model.Product;
import com.gates.dao.repository.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository=productRepository;
	}
	
	public List<Product> getAllProducts(){
		List<Product> productList = productRepository.findAll();
		return productList;
	}
	
	public GeneralResponse addProduct(Product product){
		GeneralResponse generalResponseDTO = new GeneralResponse();
	
		boolean count = productRepository.existsByBarcode(product.getBarcode());
		if(count==true) {
			generalResponseDTO.setMessage("Ürün kayıtlı.");
			generalResponseDTO.setStatus("f");
		} else {
			generalResponseDTO.setMessage("Ürün başarıyla eklendi");
			generalResponseDTO.setStatus("s");
			productRepository.save(product);
		}
		return generalResponseDTO;
	}
	

}
