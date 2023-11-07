package com.nagarro.productCatalogs.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.productCatalogs.model.Product;
import com.nagarro.productCatalogs.repository.ProductRepository;
import com.nagarro.productCatalogs.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}


	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}


	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}



	
	

}
