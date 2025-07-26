package com.laptoprental.backend.controller;

import com.laptoprental.backend.entity.Cart;
import com.laptoprental.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam Long userId,
                                          @RequestParam Long laptopId,
                                          @RequestParam int quantity) {
        return ResponseEntity.ok(cartService.addToCart(userId, laptopId, quantity));
    }

    @DeleteMapping("/remove/{itemId}")
    public ResponseEntity<?> removeItem(@PathVariable Long itemId) {
        cartService.removeFromCart(itemId);
        return ResponseEntity.ok("Item removed");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getUserCart(userId));
    }

    @DeleteMapping("/clear/{userId}")
    public ResponseEntity<?> clearCart(@PathVariable Long userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart cleared");
    }
}
