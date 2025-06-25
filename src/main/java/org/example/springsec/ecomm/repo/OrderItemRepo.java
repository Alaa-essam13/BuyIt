package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.OrderItem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {


    @EntityGraph(attributePaths = {
            "order",
            "product"
    })
    @Query("""
            select oi from OrderItem oi where oi.order.id = :id
""")
    List<OrderItem> getByOrderId(Long id);

}
