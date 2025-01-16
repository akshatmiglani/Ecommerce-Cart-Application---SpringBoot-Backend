package com.shoppingcart.akshatshop.repository;

import com.shoppingcart.akshatshop.model.Cart;
import com.shoppingcart.akshatshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
