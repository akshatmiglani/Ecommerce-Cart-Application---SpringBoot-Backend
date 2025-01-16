package com.shoppingcart.akshatshop.service.cart;

import com.shoppingcart.akshatshop.exceptions.ResourceNotFoundException;
import com.shoppingcart.akshatshop.model.Cart;
import com.shoppingcart.akshatshop.model.CartItem;
import com.shoppingcart.akshatshop.repository.CartItemRepository;
import com.shoppingcart.akshatshop.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;


    @Override
    public Cart getCart(Long id) {
        Cart cart = cartRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cart not found"));
        BigDecimal totalAmount = cart.getTotalAmount();
        cart.setTotalAmount(totalAmount);
        return cartRepository.save(cart);

    }

    @Transactional
    @Override
    public void clearCart(Long id) {

        Cart cart = getCart(id);
        cartItemRepository.deleteAllByCartId(id);
        cart.getItems().clear();
        cartRepository.deleteById(id);


    }

    @Override
    public BigDecimal getTotalPrice(Long id) {
        Cart cart = getCart(id);
        return cart.getItems().stream().map(CartItem::getTotalPrice).reduce(BigDecimal.ZERO,BigDecimal::add);

    }

    @Override
    public Long initializeNewCart() {
        Cart newCart = new Cart();
        return cartRepository.save(newCart).getId();

    }
}
