package com.nagarro.productCatalogs.services.impl;

import org.springframework.stereotype.Service;

import com.nagarro.productCatalogs.model.User;
import com.nagarro.productCatalogs.repository.UserRepository;
import com.nagarro.productCatalogs.services.UserService;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	

	public UserServiceImpl(UserRepository userRespository) {
		super();
		this.userRepository = userRespository;
	}
	
	@Override
	public String saveUser(User user) {
		// TODO Auto-generated method stub
		
		if (userRepository.getByGmail(user.getGmail()) != null) 
			
	        return "Username Already Exist";
	    
		else 
	        userRepository.save(user);
		
		return "Successfull";
		
	}

	@Override
	public User findByGmail(String gmail) {
		// TODO Auto-generated method stub
	return userRepository.getById(gmail);

	}

	
	

}


