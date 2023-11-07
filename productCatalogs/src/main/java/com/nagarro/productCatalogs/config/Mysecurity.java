package com.nagarro.productCatalogs.config;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;

import com.nagarro.productCatalogs.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class Mysecurity extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint authEntryPoint;
//	 @Override
//	    protected void configure(HttpSecurity httpSecurity) throws Exception {
//	        httpSecurity.cors();
//	        httpSecurity.csrf().disable()
//	                .authorizeRequests().antMatchers("/userRegister").permitAll()
//	                .antMatchers(HttpHeaders.ALLOW).permitAll()
//	                .anyRequest().authenticated()
//	                .and()
//	                .exceptionHandling().authenticationEntryPoint(authEntryPoint)
//	                .and()
//	                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//	        ;
//
//	        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//	    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors();
		http
		     .csrf()
		     .disable()
		     .authorizeRequests()
		     .antMatchers("/token","/registerNewUsers", "/api/search/all/{id}","/api/search/code/{code}","/api/search/name/{name}","/api/search/brand/{brand}","/api/addProduct").permitAll()
		     .antMatchers(HttpHeaders.ALLOW).permitAll()
		     .anyRequest().authenticated()
		     .and()
		     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		     .and()
		     .exceptionHandling().authenticationEntryPoint(authEntryPoint)
		     .and()
		     .formLogin().disable();
		     
		     
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		     
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(customUserDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public AuthenticationManager AuthenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
