package org.example.springsec.ecomm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private Double price;
    private int stock;
    private String imageUrl;
    private Long cat_id;
    private Long brand_id;

}
