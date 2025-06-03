package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.entity.Cart;
import org.example.springsec.ecomm.entity.CartItem;
import org.example.springsec.ecomm.entity.Product;
import org.example.springsec.ecomm.repo.CartItemRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepo cartItemRepo;

    private final CartService cartService;

    private final ProductService productService;


    public void addItemToCart(Long productId, Long userId,int quantity) {
        Cart c=cartService.getCartByUserId(userId);
        Product p = productService.getProduct(productId);
        cartItemRepo.save(CartItem.builder().cart(c).product(p).quantity(quantity).price(p.getPrice()).build());
    }


}
