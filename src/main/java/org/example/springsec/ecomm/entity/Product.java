package org.example.springsec.ecomm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String name;
    private String description;
    @Min(0)
    private Double price;
    private int stock;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
