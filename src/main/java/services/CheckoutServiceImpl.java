package services;

//import dao.CartItemRepository;
import dao.CartRepository;
//import dao.CustomerRepository;
import entities.Cart;
import entities.CartItem;
import entities.Customer;
import entities.StatusType;
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
        cartItems.forEach(cart::add);

        cart.setStatus(StatusType.ORDERED);

        Customer customer = purchase.getCustomer();
        customer.add(cart);
        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();

    }

}