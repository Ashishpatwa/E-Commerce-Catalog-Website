package com.nagarro.productCatalogs.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.productCatalogs.model.Product;
import com.nagarro.productCatalogs.repository.SearchRepository;
import com.nagarro.productCatalogs.services.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
	
	private SearchRepository searchRepository;
	
	public SearchServiceImpl(SearchRepository searchRepository) {
		super();
		this.searchRepository = searchRepository;
	}
	
	@Override
	public List<Product> getAllSearch(String productCode, String name, String brand) {
		// TODO Auto-generated method stub
		return searchRepository.findByProductCodeContainingIgnoreCaseOrNameContainingIgnoreCaseOrBrandContainingIgnoreCase(productCode, name, brand);
	}

	
	
	
	

}
