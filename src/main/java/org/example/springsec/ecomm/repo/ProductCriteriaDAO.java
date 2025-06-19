package org.example.springsec.ecomm.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.entity.Brand;
import org.example.springsec.ecomm.entity.Category;
import org.example.springsec.ecomm.entity.Product;
import org.example.springsec.ecomm.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductCriteriaDAO {

    private final EntityManager em;

    public Page<Product> searchForProduct(String searchReq, Pageable pageable) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> root = cq.from(Product.class);

        Join<Product, Brand> joinBrand = root.join("brand");
        Join<Product, Category> joinCategory = root.join("category");

        List<Predicate> predicates = new ArrayList<>();

        if (searchReq!= null && !searchReq.isEmpty()) {
            predicates.add(cb.like(root.get("title"), searchReq));
            predicates.add(cb.like(joinCategory.get("name"), searchReq));
            predicates.add(cb.like(joinBrand.get("name"), searchReq));
        }
        if(!predicates.isEmpty()){
            cq.where(cb.or(predicates.toArray(new Predicate[0])));
        }

        TypedQuery<Product> query = em.createQuery(cq);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        long total = countProducts(searchReq);

        List<Product> products = query.getResultList();

        return new PageImpl<>(products, pageable, total);

    }

    private long countProducts(String searchReq) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Product> root = cq.from(Product.class);

        Join<Product, Brand> joinBrand = root.join("brand");
        Join<Product, Category> joinCategory = root.join("category");

        List<Predicate> predicates = new ArrayList<>();

        if (searchReq != null && !searchReq.isEmpty()) {
            predicates.add(cb.like(root.get("title"), searchReq));
            predicates.add(cb.like(joinCategory.get("name"), searchReq));
            predicates.add(cb.like(joinBrand.get("name"), searchReq));
        }

        if (!predicates.isEmpty()) {
            cq.where(cb.or(predicates.toArray(new Predicate[0])));
        }

        cq.select(cb.count(root));
        return em.createQuery(cq).getSingleResult();
    }

    public Page<Product> sortProducts(String sortReq,Pageable pageable) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.groupBy(root.get("id"));
        switch (sortReq) {
            case "rev" -> {
                Join<Product, Review> joinBrand = root.join("reviews");
                cq.orderBy(cb.desc(joinBrand.get("id")));
            }
            case "date" -> {
            }
            case "cat" -> {

            }
            default -> cq.orderBy(cb.desc(root.get("id")));
        }

        TypedQuery<Product> query = em.createQuery(cq);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        long total=countProductsForSorting();

       return new PageImpl<>(query.getResultList(), pageable, total);

    }

    private long countProductsForSorting() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(cb.countDistinct(root.get("id")));
        return em.createQuery(cq).getSingleResult();
    }




}
