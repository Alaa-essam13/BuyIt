package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);
}
