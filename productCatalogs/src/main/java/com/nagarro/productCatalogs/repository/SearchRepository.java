package com.nagarro.productCatalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nagarro.productCatalogs.model.Product;

public interface SearchRepository extends CrudRepository<Product, String>{
	
	public List<Product> findByProductCodeContainingIgnoreCaseOrNameContainingIgnoreCaseOrBrandContainingIgnoreCase(String productCode, String name, String brand);
	public List<Product> findByProductCode(String code);
	public List<Product> findByName(String name);
	public List<Product> findByBrand(String brand);
	public List<Product> findByPriceLessThanEqual(int price);

}
