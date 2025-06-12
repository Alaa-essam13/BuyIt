package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.entity.Cart;
import org.example.springsec.ecomm.entity.CartItem;
import org.example.springsec.ecomm.repo.CartRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepo cartRepo;

    public Cart getCartById(Long id) {
        return cartRepo.findById(id).orElseThrow();
    }

    public Cart getCartByUserId(Long userId) {
        return cartRepo.findByUserId(userId);
    }

    public List<CartItem> getAllCartItems(Long userId) {
        return cartRepo.getCartItemsById(userId)
                .map(Cart::getCartItems)
                .orElse(Collections.emptyList());
    }

    public ResponseEntity<Void> deleteCartItem(Long userId, Long cartItemId) {

        return ResponseEntity.ok().build();
    }
}