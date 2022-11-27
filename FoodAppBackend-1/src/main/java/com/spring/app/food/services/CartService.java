package com.spring.app.food.services;

import java.util.Collection;

import com.spring.app.food.models.Cart;
import com.spring.app.food.models.ProductInOrder;
import com.spring.app.food.models.User;


public interface CartService {
    Cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}

