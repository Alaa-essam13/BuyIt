package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Long> {

    @Query("delete from CartItem ci where ci.cart.id = :cartId and ci.id = :cartItemId")
    @Modifying
    void deletecartItem(Long cartId, Long cartItemId);

    @Query("delete from CartItem ci where ci.cart.id = :cartId")
    @Modifying
    void flushcart(Long cartId);
}
