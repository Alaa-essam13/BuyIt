package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
}
