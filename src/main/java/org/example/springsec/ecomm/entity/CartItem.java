package org.example.springsec.ecomm.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "_cartItem")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne(cascade = PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;
}
