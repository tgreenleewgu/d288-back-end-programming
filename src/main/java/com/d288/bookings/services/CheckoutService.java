package com.d288.bookings.services;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
