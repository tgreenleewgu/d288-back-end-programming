package com.d288.bookings.dao;

import com.d288.bookings.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "cartItems", path = "cartItems")
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
