package com.spring.app.food.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Cart implements Serializable {
    
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
//    @JoinColumn(name = "email", referencedColumnName = "email")
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true,
            mappedBy = "cart")
    private Set<ProductInOrder> products = new HashSet<>();

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", products=" + products +
                '}';
    }

    public Cart(User user) {
        this.user  = user;
    }

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ProductInOrder> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductInOrder> products) {
		this.products = products;
	}

	public Cart(long cartId, User user, Set<ProductInOrder> products) {
		super();
		this.cartId = cartId;
		this.user = user;
		this.products = products;
	}

	public Cart(User user, Set<ProductInOrder> products) {
		super();
		this.user = user;
		this.products = products;
	}
public Cart() {
	//TODO Auto-generated constructor stub
}
}