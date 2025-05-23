package org.example.springsec.ecomm.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "_cartItem")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CartItem {
    @Id
    private Long id;
    private int quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;


}
