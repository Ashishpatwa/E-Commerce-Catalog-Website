package com.nagarro.productCatalogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.productCatalogs.model.User;
import com.nagarro.productCatalogs.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	  @Autowired
	    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User user = userRepository.findById(username).get();

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getGmail(),
                    user.getPassword(), new ArrayList<>()
                  
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
	}


}
