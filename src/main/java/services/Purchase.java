package services;

import entities.Cart;
import entities.CartItem;
import entities.Customer;
import lombok.*;


import java.util.Set;

@Getter
@Setter
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}

