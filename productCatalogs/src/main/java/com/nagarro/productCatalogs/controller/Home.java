package com.nagarro.productCatalogs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "hii ashish";
	}
	
	@RequestMapping("/getusers")
	public String getUser() {
		return "hii";
	}

}
