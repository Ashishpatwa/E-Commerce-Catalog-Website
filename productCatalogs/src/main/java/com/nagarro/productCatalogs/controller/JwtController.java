package com.nagarro.productCatalogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productCatalogs.helper.JwtUtil;
import com.nagarro.productCatalogs.model.JwtRequest;
import com.nagarro.productCatalogs.model.JwtResponse;
import com.nagarro.productCatalogs.services.CustomUserDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtController {
	
	@Autowired
	private AuthenticationManager authorizationManager;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	
	 @PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		
		try {
			
		 this.authorizationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getGmail(),jwtRequest.getPassword()));
			
		}
		catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getGmail());
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println(token);
		
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	}
}

