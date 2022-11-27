package com.spring.app.food.controllers;

import java.security.Principal;

import com.spring.app.food.models.User;
import com.spring.app.food.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
public class UserController {
	 @Autowired
	  UserRepository userRepository;
	

	    @GetMapping("/profile/{email}")
	    public ResponseEntity<User> getProfile(@PathVariable("email") String email, Principal principal) {
	        if (principal.getName().equals(email)) {
	            return ResponseEntity.ok(userRepository.findByEmail(email));
	        } else {
	            return ResponseEntity.badRequest().build();
	        } 
	 
}}