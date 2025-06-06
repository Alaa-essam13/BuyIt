package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    public Category findByName(String name);
}
