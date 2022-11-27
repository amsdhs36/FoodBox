package com.spring.app.food.services;

import com.spring.app.food.models.ProductInOrder;
import com.spring.app.food.models.User;

public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
}
