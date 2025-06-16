package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BrandRepo extends JpaRepository<Brand, Long> {
}
