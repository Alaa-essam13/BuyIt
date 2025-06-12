package org.example.springsec.ecomm.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.entity.CartItem;
import org.example.springsec.ecomm.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItem>> getcartItems(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(cartService.getAllCartItems(userId));
    }

}
