package org.example.springsec.ecomm.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.service.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart-items")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping("/add")
    public void addItemToCart(@RequestParam("productId") Long productId
            ,@RequestParam("userId")  Long userId
            ,@RequestParam("quantity")  int quantity) {
        cartItemService.addItemToCart(productId, userId,quantity);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteVoid(@RequestParam("c_id") Long cartId,@RequestParam("ci_id") Long cartItemId) {
        return cartItemService.deleteCartItem(cartId,cartItemId);
    }

}
