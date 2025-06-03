package org.example.springsec.ecomm.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


}
