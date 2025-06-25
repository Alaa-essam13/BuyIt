package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.dto.OrderDto;
import org.example.springsec.ecomm.dto.PaymentMethod;
import org.example.springsec.ecomm.entity.Order;
import org.example.springsec.ecomm.entity.User;
import org.example.springsec.ecomm.repo.OrderRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final UserService userService;

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElseThrow();
    }

    public ResponseEntity<Void> saveOrder(OrderDto orderDto, Long userId) {
        User user = userService.getUserById(userId);
        if(user.getAddresses().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        orderRepo.save(Order.builder()
                .totalPrice(orderDto.getTotalPrice())
                .status(orderDto.getStatus())
                .createdAt(orderDto.getCreatedAt())
                .paymentMethod(PaymentMethod.fromInt(orderDto.getPaymentMethod()))
                .address(user.getAddresses().get(0).toString())
                .user(user)
                .build());
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<List<OrderDto>> getOrdersByUserId(Long userId) {
        return ResponseEntity.ok(orderRepo.getOrdersOfUser(userId));
    }

}
