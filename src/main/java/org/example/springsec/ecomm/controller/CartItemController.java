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


    @DeleteMapping("/delete/all")
    public ResponseEntity<Void> deleteAllItemsInCart(@RequestParam("c_id") Long cartId) {
        return cartItemService.flushCart(cartId);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteItemFromCart(@RequestParam("ci_id") Long id) {
        return cartItemService.removeItemFromCart(id);
    }

    @PutMapping("/quantity")
    public ResponseEntity<Void> changeQuantity(@RequestParam("ci_id") Long cid,@RequestParam("quantity") int quantity) {
        return cartItemService.changeQuantity(cid,quantity);
    }

}
