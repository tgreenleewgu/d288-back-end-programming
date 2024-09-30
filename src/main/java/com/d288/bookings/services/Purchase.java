package com.d288.bookings.services;

import com.d288.bookings.entities.Cart;
import com.d288.bookings.entities.CartItem;
import com.d288.bookings.entities.Customer;
import lombok.*;


import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}

