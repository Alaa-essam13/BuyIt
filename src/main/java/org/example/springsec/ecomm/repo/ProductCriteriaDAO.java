package org.example.springsec.ecomm.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.dto.SearchReq;
import org.example.springsec.ecomm.entity.Brand;
import org.example.springsec.ecomm.entity.Category;
import org.example.springsec.ecomm.entity.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductCriteriaDAO {

    private final EntityManager em;

    public List<Product> searchForProduct(SearchReq searchReq) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> root = cq.from(Product.class);

        Join<Product, Brand> joinBrand = root.join("brand");
        Join<Product, Category> joinCategory = root.join("category");

        List<Predicate> predicates = new ArrayList<>();

        if (searchReq.getTitle() != null && !searchReq.getTitle().isEmpty()) {
            predicates.add(cb.like(root.get("title"), searchReq.getTitle()));
        }
        if (searchReq.getCategoryName() != null && !searchReq.getCategoryName().isEmpty()) {
            predicates.add(cb.like(joinCategory.get("name"), searchReq.getCategoryName()));
        }
        if (searchReq.getBrandName() != null && !searchReq.getBrandName().isEmpty()) {
            predicates.add(cb.like(joinBrand.get("name"), searchReq.getBrandName()));
        }
        cq.where(cb.or(predicates.toArray(new Predicate[0])));

        TypedQuery<Product> query = em.createQuery(cq);

        return query.getResultList();

    }


}
