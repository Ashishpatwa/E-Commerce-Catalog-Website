package com.nagarro.productCatalogs.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productCatalogs.model.Serviceabilty;
import com.nagarro.productCatalogs.repository.ServiceabiltyRepository;


@RestController
@CrossOrigin
public class ServiceabiltyController {
	

	
	@Autowired
	private ServiceabiltyRepository ServiceablityRepository;
	
	@RequestMapping("/serviceabilty/{id}/{code}")
	public List<Serviceabilty> getServiceabilty(@PathVariable("id") int id, @PathVariable("code") int code)
	{
		return ServiceablityRepository.findByProductidAndPincodes(id,code);

	}
}
