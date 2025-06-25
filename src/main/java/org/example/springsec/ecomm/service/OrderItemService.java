package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.entity.OrderItem;
import org.example.springsec.ecomm.repo.OrderItemRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderItemRepo orderItemRepo;


    @Transactional
    public ResponseEntity<Void> addOrdersItem(List<OrderItem> orderItems){
        orderItemRepo.saveAllAndFlush(orderItems);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<OrderItem>> getAllOrdersItemByOrderId(Long orderId){
        return ResponseEntity.ok(orderItemRepo.getByOrderId(orderId));
    }

}
