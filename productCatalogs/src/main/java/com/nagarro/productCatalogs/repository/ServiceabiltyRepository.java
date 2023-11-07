package com.nagarro.productCatalogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.nagarro.productCatalogs.model.Serviceabilty;


public interface ServiceabiltyRepository extends JpaRepository<Serviceabilty, Integer> {
	
	
	 List<Serviceabilty> findByProductidAndPincodes(int id ,int code);
	

}
