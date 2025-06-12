package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
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
        log.info("Adding item to cart " + c.getId());
        if (p.getStock() >= quantity) {
            CartItem ci =CartItem.builder().cart(c).product(p).quantity(quantity).price(p.getPrice()).build();
            cartItemRepo.save(ci);
            log.info("Added product to cart item"+ci.getId());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public ResponseEntity<Void> removeItemFromCart(Long cartItemId) {
        CartItem cartItem=getCartItem(cartItemId);
        cartItemRepo.delete(cartItem);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> changeQuantity(Long cartItemId, Integer quantity) {
        CartItem cartItem = getCartItem(cartItemId);
        cartItem.setQuantity(quantity);
        cartItemRepo.save(cartItem);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Void> deleteCartItem(Long cartId,Long cartItemId) {
         cartItemRepo.deletecartItem(cartId,cartItemId);
         return ResponseEntity.ok().build();
    }


}
