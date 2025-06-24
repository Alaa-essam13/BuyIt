package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.Brand;
import org.example.springsec.ecomm.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BrandRepo extends JpaRepository<Brand, Long> {


    @EntityGraph(attributePaths = {
            "products"
    })
    @Query("""
        select b.products from Brand b where b.id = :b_id
""")
    List<Product> getProductsByBrandId(Long b_id);

}
