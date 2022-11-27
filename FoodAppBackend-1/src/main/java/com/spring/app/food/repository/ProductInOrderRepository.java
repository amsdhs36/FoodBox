package com.spring.app.food.repository;

import com.spring.app.food.models.ProductInOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, Long> {

}

