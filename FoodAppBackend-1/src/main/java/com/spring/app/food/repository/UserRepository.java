package com.spring.app.food.repository;


import java.util.Optional;

import com.spring.app.food.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String name);

  Boolean existsByEmail(String email);
  User findByEmail(String email);
    
}
