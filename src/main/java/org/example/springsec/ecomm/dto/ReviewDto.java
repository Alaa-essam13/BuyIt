package org.example.springsec.ecomm.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewDto {
    @Min(0)
    @Max(5)
    private Double rating;
    private String comment;
    private Long u_id;
    private Long p_id;
}
