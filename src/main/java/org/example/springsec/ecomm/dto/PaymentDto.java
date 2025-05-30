package org.example.springsec.ecomm.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class PaymentDto {
    private Long id;
    private int amount;
    private String status;
    private int paymentMethod;
}
