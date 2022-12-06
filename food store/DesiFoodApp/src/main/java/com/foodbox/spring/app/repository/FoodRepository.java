package com.foodbox.spring.app.repository;

import com.foodbox.spring.app.model.Food;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food,Long>{
	

}
