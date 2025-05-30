package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.dto.PaymentDto;
import org.example.springsec.ecomm.dto.PaymentMethod;
import org.example.springsec.ecomm.entity.Payment;
import org.example.springsec.ecomm.repo.PaymentRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepo paymentRepo;
    private final OrderService orderService;

    public void savePayment(PaymentDto paymentDto, Long userId, Long orderId) {
        paymentRepo.save(Payment.builder()
                .amount(paymentDto.getAmount())
                .status(paymentDto.getStatus())
                .paymentDate(LocalDateTime.now())
                .paymentMethod(PaymentMethod.fromInt(paymentDto.getPaymentMethod()))
                .order(orderService.getOrderById(orderId))
                .build());
    }


}
