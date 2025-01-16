package com.shoppingcart.akshatshop.service.cart;

import com.shoppingcart.akshatshop.model.Cart;
import com.shoppingcart.akshatshop.model.CartItem;

import java.math.BigDecimal;

public interface ICartItemService {

    void addItemToCart(Long cartId, Long productId, int quantity);
    void removeItemFromCart(Long cartId, Long productId);
    void updateItemQuantity(Long cartId,Long productId,int quantity);

    CartItem getCartItem(Long cartId, Long productId);
}
