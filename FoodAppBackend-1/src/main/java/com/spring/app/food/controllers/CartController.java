package com.spring.app.food.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;

import com.spring.app.food.form.ItemForm;
import com.spring.app.food.models.Cart;
import com.spring.app.food.models.ProductInOrder;
import com.spring.app.food.models.User;
import com.spring.app.food.repository.ProductInOrderRepository;
import com.spring.app.food.services.CartService;
import com.spring.app.food.services.ProductInOrderService;
import com.spring.app.food.services.ProductService;
import com.spring.app.food.services.UserService;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductInOrderService productInOrderService;
    @Autowired
    ProductInOrderRepository productInOrderRepository;

    @PostMapping("")
    public ResponseEntity<Cart> mergeCart(@RequestBody Collection<ProductInOrder> productInOrders, Principal principal) {
        User user = userService.findOne(principal.getName());
        try {
            cartService.mergeLocalCart(productInOrders, user);
        } catch (Exception e) {
            ResponseEntity.badRequest().body("Merge Cart Failed");
        }
        return ResponseEntity.ok(cartService.getCart(user));
    }

    @GetMapping("")
    public Cart getCart(Principal principal) {
        User user = userService.findOne(principal.getName());
        return cartService.getCart(user);
    }


    @PostMapping("/add")
    public boolean addToCart(@RequestBody ItemForm form, Principal principal) {
        var productInfo = productService.findOne(form.getProductId());
        try {
            mergeCart(Collections.singleton(new ProductInOrder(productInfo, form.getQuantity())), principal);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @PutMapping("/{itemId}")
    public ProductInOrder modifyItem(@PathVariable("itemId") String itemId, @RequestBody Integer quantity, Principal principal) {
        User user = userService.findOne(principal.getName());
         productInOrderService.update(itemId, quantity, user);
        return productInOrderService.findOne(itemId, user);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable("itemId") String itemId, Principal principal) {
        User user = userService.findOne(principal.getName());
         cartService.delete(itemId, user);
         // flush memory into DB
    }


    @SuppressWarnings("rawtypes")
	@PostMapping("/checkout")
    public ResponseEntity checkout(Principal principal) {
        User user = userService.findOne(principal.getName());// Email as username
        cartService.checkout(user);
        return ResponseEntity.ok(null);
    }


}
