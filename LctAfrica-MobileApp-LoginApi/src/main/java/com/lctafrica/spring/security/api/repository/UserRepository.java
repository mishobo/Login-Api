package com.lctafrica.spring.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lctafrica.spring.security.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	// User findAllByEmail(String username);

	User findByEmailAndPassword(String email, String password);


}
