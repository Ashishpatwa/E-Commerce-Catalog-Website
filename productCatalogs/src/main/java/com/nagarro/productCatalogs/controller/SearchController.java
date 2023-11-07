package com.nagarro.productCatalogs.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productCatalogs.model.Product;
import com.nagarro.productCatalogs.repository.SearchRepository;

@RestController
@RequestMapping("/api/search")
//@CrossOrigin
public class SearchController {
	
	private SearchRepository searchRepository;

	public SearchController(SearchRepository searchRepository) {
		super();
		this.searchRepository = searchRepository;
	}
	
	
	@GetMapping("/all/{id}")
    public List<Product> searchProducts(@PathVariable("id") String keyword) {
		System.out.println(keyword);
        List<Product> products = searchRepository.findByProductCodeContainingIgnoreCaseOrNameContainingIgnoreCaseOrBrandContainingIgnoreCase(keyword, keyword, keyword);
        return products;
    }
	
		
	@GetMapping("/code/{code}")
		public List<Product> getCode(@PathVariable("code") String code)
		{
			return searchRepository.findByProductCode(code);

		}
		
	@GetMapping("/name/{name}")
		public List<Product> getName(@PathVariable("name") String name)
		{
			return searchRepository.findByName(name);

		}
		
	@GetMapping("/brand/{brand}")
		public List<Product> getBrand(@PathVariable("brand") String brand)
		{
			return searchRepository.findByBrand(brand);

		}
		
	@GetMapping("/price/{price}")
		public List<Product> getPrice(@PathVariable("price") int price)
		{
			return searchRepository.findByPriceLessThanEqual(price);

		}
		
	

	

}
