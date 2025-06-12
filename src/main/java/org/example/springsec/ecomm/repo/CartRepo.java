package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.Cart;
import org.example.springsec.ecomm.entity.CartItem;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
//    Cart findByUserId(Long userId);

    @Query("select c from Cart c where c.user.id = :userId")
    Cart findByUserId(Long userId);

    @EntityGraph(
            attributePaths = {
                    "user",
                    "cartItems",
                    "cartItems.product"
            }
    )
    @Query("select c from Cart c where c.user.id = :userId")
    Optional<Cart> getCartItemsById(Long userId);


}
