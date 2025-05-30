package org.example.springsec.ecomm.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CategoryDto {
    private String name;
    private String description;
}
