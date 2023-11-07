package com.nagarro.productCatalogs.services;

import com.nagarro.productCatalogs.model.User;

public interface UserService {
	
	String saveUser(User user);
	User findByGmail(String gmail);
	

}

