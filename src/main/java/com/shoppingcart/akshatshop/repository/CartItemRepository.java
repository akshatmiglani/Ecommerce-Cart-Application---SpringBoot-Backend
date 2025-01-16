package com.shoppingcart.akshatshop.repository;

import com.shoppingcart.akshatshop.model.Cart;
import com.shoppingcart.akshatshop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    void deleteAllByCartId(Long id);
}
