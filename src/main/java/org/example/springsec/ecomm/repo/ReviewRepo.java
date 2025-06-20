package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    @Query("""
        select r from Review r where r.product.id = :id
""")
    List<Review> findByProductId(Long id);
}
