package com.nagarro.productCatalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.productCatalogs.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	
//	public String findByProductCodeContainingIgnoreCase(String productCode);

	public List<Product> findByProductCodeContainingIgnoreCase(String keyword);	

	

}
