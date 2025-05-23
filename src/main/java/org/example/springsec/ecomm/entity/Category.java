package org.example.springsec.ecomm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category {
    @Id
    private Long id;
    @NotNull
    private String name;
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
