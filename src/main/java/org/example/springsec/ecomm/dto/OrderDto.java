package org.example.springsec.ecomm.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class OrderDto {
    private Double totalPrice;
    private String status;
    private LocalDateTime createdAt;
    private int paymentMethod;
    private String address;
}
