package org.example.springsec.ecomm.repo;

import org.example.springsec.ecomm.dto.ProductDto;
import org.example.springsec.ecomm.entity.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("select new org.example.springsec.ecomm.dto.ProductDto(p.name, p.description, p.price, p.stock, p.imageUrl, p.category.id, p.brand.id) from Product p where p.brand.id = :brandId")
    List<ProductDto> findByBrand_Id(Long brandId);

    @EntityGraph(attributePaths = {"brand", "category"})
    @Query("""
            select new org.example.springsec.ecomm.dto.ProductDto(
                        p.name,
                        p.description,
                        p.price,
                        p.stock,
                        p.imageUrl,
                        p.category.id,
                        p.brand.id) 
                        from Product p """)
    List<ProductDto> findallProducts();

}
