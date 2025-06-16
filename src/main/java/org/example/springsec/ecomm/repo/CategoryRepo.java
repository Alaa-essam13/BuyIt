package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Query("""
        select c from Category c where c.name = :name
""")
    public Category findByName(String name);
}
