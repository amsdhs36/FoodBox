package com.spring.app.food.services;



import com.spring.app.food.models.User;



public interface UserService {

	    User findOne(String email);

	    
	    User save(User user);

	    User update(User user);
	}


