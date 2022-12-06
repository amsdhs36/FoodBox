package com.foodbox.spring.app.repository;

import com.foodbox.spring.app.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
