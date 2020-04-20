package com.lctafrica.spring.security.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lctafrica.spring.security.api.model.User;
import com.lctafrica.spring.security.api.repository.UserRepository;

@Service
public class CustomUserDetailsService {	
	@Autowired
	private UserRepository repository;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user=repository.findAllByEmail(username);
//		CustomUserDetails userDetails=null;
//		// if user is found
//		if(user != null) {
//			userDetails = new CustomUserDetails();
//			userDetails.setUser(user);
//		}else {
//			throw new UsernameNotFoundException("User with email "+username+" does not exist");
//		}
//		return userDetails;
//	}
	
	
	
	public User authUser(User user) throws Exception{
		System.out.println("########## User Email" +user.getEmail());
		System.out.println("########## User password" +user.getPassword());
		return repository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		
		
	}
	
	

}
