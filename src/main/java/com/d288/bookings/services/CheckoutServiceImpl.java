package com.d288.bookings.services;


import com.d288.bookings.dao.CartRepository;
import com.d288.bookings.dao.CustomerRepository;
import com.d288.bookings.entities.Cart;
import com.d288.bookings.entities.CartItem;
import com.d288.bookings.entities.Customer;
import com.d288.bookings.entities.StatusType;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

//    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
//        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
//        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));
        String orderTrackingNumber = generateOrderTrackingNumber();

//        cartItems.forEach(item -> {
//            item.setCart(cart);
//            cart.add(item);
//        });

        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
//        customer.add(cart);

        cartRepository.save(cart);
//        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();

    }
}
