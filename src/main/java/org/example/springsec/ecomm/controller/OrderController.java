package org.example.springsec.ecomm.controller;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.dto.OrderDto;
import org.example.springsec.ecomm.entity.Order;
import org.example.springsec.ecomm.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addOrder(@RequestBody OrderDto orderDto,@RequestParam Long userId) {
        return orderService.saveOrder(orderDto,userId);
    }

    @GetMapping("/user")
    public ResponseEntity<List<OrderDto>> getOrdersOfUser(@RequestParam Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

}
