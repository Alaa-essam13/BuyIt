package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.entity.Cart;
import org.example.springsec.ecomm.repo.CartRepo;
import org.springframework.stereotype.Service;

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

}
