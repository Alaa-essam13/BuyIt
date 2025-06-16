package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
