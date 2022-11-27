package com.spring.app.food.repository;



import com.spring.app.food.models.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}

