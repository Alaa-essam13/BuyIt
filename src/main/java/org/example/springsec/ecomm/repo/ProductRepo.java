package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.dto.ProductDto;
import org.example.springsec.ecomm.entity.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<ProductDto> findByBrand_Id(Long brandId);
}
