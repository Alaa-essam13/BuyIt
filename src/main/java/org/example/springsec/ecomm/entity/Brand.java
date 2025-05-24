package org.example.springsec.ecomm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "_brand")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private String name;
    private String description;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;
}
