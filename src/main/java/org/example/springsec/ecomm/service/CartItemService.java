package org.example.springsec.ecomm.service;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.entity.Cart;
import org.example.springsec.ecomm.entity.CartItem;
import org.example.springsec.ecomm.entity.Product;
import org.example.springsec.ecomm.repo.CartItemRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepo cartItemRepo;

    private final CartService cartService;

    private final ProductService productService;

    private CartItem getCartItem(Long id) {
        return cartItemRepo.findById(id).orElse(null);
    }


    @Transactional
    public ResponseEntity<Void> addItemToCart(Long productId, Long userId, int quantity) {
        Cart c = cartService.getCartByUserId(userId);
        Product p = productService.getProduct(productId);
        if (p.getStock() >= quantity) {
            CartItem ci =CartItem.builder().cart(c).product(p).quantity(quantity).price(p.getPrice()).build();
            cartItemRepo.save(ci);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<Void> removeItemFromCart(Long cartItemId) {
        CartItem cartItem=getCartItem(cartItemId);
        if (cartItem!=null) {
            cartItemRepo.deleteById(cartItemId);
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> changeQuantity(Long cartItemId, int quantity) {
        CartItem cartItem = getCartItem(cartItemId);
        if(quantity<0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if (quantity==0){
            return removeItemFromCart(cartItemId);
        }
        if (cartItem!=null) {
            cartItem.setQuantity(quantity);
            cartItemRepo.save(cartItem);
        }
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Void> flushCart(Long cartId) {
        cartItemRepo.flushcart(cartId);
        return ResponseEntity.ok().build();
    }


}
