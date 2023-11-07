
package com.nagarro.productCatalogs.services;

import java.util.List;

import com.nagarro.productCatalogs.model.Product;

public interface SearchService {
	
	List<Product> getAllSearch(String productCode, String name,String brand);

}
