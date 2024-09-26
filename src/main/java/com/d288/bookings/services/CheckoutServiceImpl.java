package com.d288.bookings.services;

//import dao.CartItemRepository;
import com.d288.bookings.dao.CartRepository;
//import dao.CustomerRepository;
import com.d288.bookings.entities.Cart;
import com.d288.bookings.entities.CartItem;
import com.d288.bookings.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private final CartRepository cartRepository;
    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository)
    {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        //cartItems.forEach(cart::add);
        cartItems.forEach(item -> cart.add(item));

        cart.setStatus(StatusType.ORDERED);
        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();

    }

}
