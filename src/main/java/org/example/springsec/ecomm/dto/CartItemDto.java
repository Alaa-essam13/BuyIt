package org.example.springsec.ecomm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class CartItemDto {
    Long cartId;
    Long productId;
    int quantity;
}
