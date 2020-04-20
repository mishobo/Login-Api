package com.lctafrica.spring.security.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lctafrica.spring.security.api.handlers.AES;
import com.lctafrica.spring.security.api.handlers.UserResponse;
import com.lctafrica.spring.security.api.model.User;
import com.lctafrica.spring.security.api.repository.UserRepository;
import com.lctafrica.spring.security.api.service.CustomUserDetailsService;

@RestController
@RequestMapping("/api")
public class ApplicationController {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private UserRepository userRepository;

	
	@PostMapping("/auth")
	public ResponseEntity<?> authUser(@RequestBody User user) throws Exception{
		String message="";
		User userauth = userRepository.findByEmailAndPassword(
				user.getEmail(),
				AES.encrypt(user.getPassword())
				);
		System.out.println(userauth);
		if(userauth == null) {
			message = "invalid credentials, UserName::" +user.getEmail() ;
			return new ResponseEntity<>(new UserResponse("Invalid User credentials", 201, false, UserResponse.APIV), HttpStatus.OK);
		}else if(userauth!=null) {
			System.out.println(user.getEmail());
			message = "User logged in succesfuly";
			return new ResponseEntity<>(new UserResponse("Login sucess!", 200, true, UserResponse.APIV, userauth), HttpStatus.OK);
		}
		
		return null;
		
	}
}
