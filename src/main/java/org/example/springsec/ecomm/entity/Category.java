package org.example.springsec.ecomm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "_category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
