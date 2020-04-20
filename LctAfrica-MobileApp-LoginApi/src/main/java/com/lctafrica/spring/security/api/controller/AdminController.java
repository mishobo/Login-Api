package com.lctafrica.spring.security.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lctafrica.spring.security.api.handlers.AES;
import com.lctafrica.spring.security.api.model.User;
import com.lctafrica.spring.security.api.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;


	@PostMapping("/register")
	public String addUserByAdmin(@RequestBody User user) throws Exception {
		String pwd = user.getPassword();
		String encryptPwd = AES.encrypt(pwd);
		user.setPassword(encryptPwd);
		userRepository.save(user);
		return "user added successfully...";
	}
}
