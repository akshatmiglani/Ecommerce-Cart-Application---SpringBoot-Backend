package com.shoppingcart.akshatshop.controller;

import com.shoppingcart.akshatshop.exceptions.ResourceNotFoundException;
import com.shoppingcart.akshatshop.model.Cart;
import com.shoppingcart.akshatshop.response.ApiResponse;
import com.shoppingcart.akshatshop.service.cart.CartItemService;
import com.shoppingcart.akshatshop.service.cart.ICartItemService;
import com.shoppingcart.akshatshop.service.cart.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/carts")
public class CartController {

    private final ICartService cartService;
    private final ICartItemService cartItemService;

    @GetMapping("/my-cart")
    public ResponseEntity<ApiResponse> getCart(Authentication authentication) {
        try {
            String username = authentication.getName();
            Cart cart = cartService.getCartForUser(username);
            return ResponseEntity.ok(new ApiResponse("User Cart", cart));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PostMapping("/my-cart/item")
    public ResponseEntity<ApiResponse> addItemToMyCart(
            Authentication authentication,
            @RequestParam Long productId,
            @RequestParam Integer quantity)
    {
        try {
            String username = authentication.getName();
            Cart cart = cartService.getCartForUser(username);
            cartItemService.addItemToCart(cart.getId(), productId, quantity);
            return ResponseEntity.ok(new ApiResponse("Item added to cart", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/my-cart/item")
    public ResponseEntity<ApiResponse> removeItemFromMyCart(
            Authentication authentication,
            @RequestParam Long productId)
    {
        try {
            String username = authentication.getName();
            Cart cart = cartService.getCartForUser(username);
            cartItemService.removeItemFromCart(cart.getId(), productId);
            return ResponseEntity.ok(new ApiResponse("Item removed from cart", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/my-cart/item")
    public ResponseEntity<ApiResponse> updateItemQuantityInMyCart(
            Authentication authentication,
            @RequestParam Long productId,
            @RequestParam int quantity)
    {
        try {
            String username = authentication.getName();
            Cart cart = cartService.getCartForUser(username);
            cartItemService.updateItemQuantity(cart.getId(), productId, quantity);
            return ResponseEntity.ok(new ApiResponse("Item quantity updated", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/my-cart/clear")
    public ResponseEntity<ApiResponse> clearCart(Authentication authentication) {
        try {
            String username = authentication.getName();
            Cart cart = cartService.getCartForUser(username);
            cartService.clearCart(cart.getId());
            return ResponseEntity.ok(new ApiResponse("Clear Cart Success", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/my-cart/total-price")
    public ResponseEntity<ApiResponse> getTotalAmount(Authentication authentication) {
        try {
            String username = authentication.getName();
            Cart cart = cartService.getCartForUser(username);
            BigDecimal total = cartService.getTotalPrice(cart.getId());
            return ResponseEntity.ok(new ApiResponse("Total Price", total));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
