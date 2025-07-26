package com.laptoprental.backend.service;

import com.laptoprental.backend.entity.Cart;
import com.laptoprental.backend.entity.Cartitem;
import com.laptoprental.backend.entity.Laptop;
import com.laptoprental.backend.repositories.CartItemRepository;
import com.laptoprental.backend.repositories.CartRepository;
import com.laptoprental.backend.repositories.LaptopRepository;
import com.laptoprental.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private UserRepository userRepository;
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUser_Id(userId).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(userRepository.findById(userId).orElseThrow());
            return cartRepository.save(newCart);
        });
    }


    public Cart addToCart(Long userId, Long laptopId, int quantity) {
        Cart cart = getCartByUserId(userId);
        Laptop laptop = laptopRepository.findById(laptopId).orElseThrow();

        Cartitem item = new Cartitem();
        item.setLaptop(laptop);
        item.setQuantity(quantity);
        item.setCart(cart);

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }



    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    public void clearCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}