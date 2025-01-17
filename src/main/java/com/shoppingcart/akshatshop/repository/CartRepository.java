package com.shoppingcart.akshatshop.repository;

import com.shoppingcart.akshatshop.model.Cart;
import com.shoppingcart.akshatshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
    Optional<Cart> findByUser(User user);
}
