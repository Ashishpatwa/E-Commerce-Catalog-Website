package com.nagarro.productCatalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.productCatalogs.model.Product;
import com.nagarro.productCatalogs.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("select u from User u where u.gmail =:gmail")
	public User getByGmail(@Param("gmail") String gmail);
	


}


