package com.nagarro.productCatalogs.services;

import java.util.List;

import com.nagarro.productCatalogs.model.Product;

public interface ProductService {
	
	Product addProduct(Product product);
	List<Product> getAllProducts();

}
