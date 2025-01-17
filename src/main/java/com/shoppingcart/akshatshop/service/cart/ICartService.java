package com.shoppingcart.akshatshop.service.cart;

import com.shoppingcart.akshatshop.model.Cart;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Cart getCartForUser(String username);
    Long initializeNewCart();
}
