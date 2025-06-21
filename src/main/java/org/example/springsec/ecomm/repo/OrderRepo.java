package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.dto.OrderDto;
import org.example.springsec.ecomm.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {


    @Query("""
        select new org.example.springsec.ecomm.dto.OrderDto(
        o.totalPrice,
        o.status,
        o.createdAt,
        o.paymentMethod,
        o.address
        )
        from Order o
        where o.user.id = :id
""")
    List<OrderDto> getOrdersOfUser(Long id);
}
