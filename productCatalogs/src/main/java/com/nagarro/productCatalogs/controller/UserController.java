package com.nagarro.productCatalogs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productCatalogs.model.Product;
import com.nagarro.productCatalogs.model.User;
import com.nagarro.productCatalogs.repository.UserRepository;
import com.nagarro.productCatalogs.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	


	@PostMapping("/registerNewUsers")
	 public ResponseEntity<String> registerNewUser(@RequestBody User user) {
	     String result = userService.saveUser(user);
	     return ResponseEntity.ok("{\"message\": \"" + result + "\"}");
	 }
	 
	
	 
	 @GetMapping("/getUserName/{gmail}")
	 public User  getUserName(@PathVariable("gmail") String gmail) {
		 
		 User result =  userService.findByGmail(gmail);
		 return result;
		 
	 }
	

	
	

}
