package org.example.springsec.ecomm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class OrderDto {
    private Double totalPrice;
    private String status;
    private LocalDateTime createdAt;
    private int paymentMethod;
    private String address;

    OrderDto(Double totalPrice, String status, LocalDateTime createdAt, PaymentMethod paymentMethod, String address) {
        this.totalPrice = totalPrice;
        this.status = status;
        this.createdAt = createdAt;
        this.paymentMethod = toCode(paymentMethod);
        this.address = address;
    }

    private int toCode(PaymentMethod method) {
        return switch (method) {
            case CREDIT_CARD -> 1;
            case DEBIT_CARD -> 2;
            case PAYPAL -> 3;
            case BANK_TRANSFER -> 4;
            case CASH -> 5;
        };
    }
}
