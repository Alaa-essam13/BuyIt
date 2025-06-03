package org.example.springsec.ecomm.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.service.PaymentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
}
