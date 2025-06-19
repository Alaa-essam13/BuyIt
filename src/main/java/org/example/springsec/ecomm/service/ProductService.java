package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.dto.ProductDto;
import org.example.springsec.ecomm.dto.SearchReq;
import org.example.springsec.ecomm.dto.SortReq;
import org.example.springsec.ecomm.entity.Product;
import org.example.springsec.ecomm.repo.ProductCriteriaDAO;
import org.example.springsec.ecomm.repo.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo  productRepo;
    private final ProductCriteriaDAO productCriteriaDAO;

    public List<ProductDto> getAllByBrandId(Long brandId) {
        return productRepo.findByBrand_Id(brandId);
    }

    public Product getProduct(Long id) {
        return productRepo.findById(id).orElseThrow();
    }

    public ProductDto getById(Long id) {
        Product product = getProduct(id);
        return ProductDto.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .imageUrl(product.getImageUrl())
                .build();
    }

    public ResponseEntity<Void> addProduct(ProductDto productDto) {
        productRepo.save(Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .stock(productDto.getStock())
                .imageUrl(productDto.getImageUrl())
                .build());
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteById(Long id) {
        productRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public List<ProductDto> getAll() {
        return productRepo.findallProducts();
    }

    public Page<Product> searchProducts(SearchReq searchReq,int page, int size,String sortType) {

        Sort sort;
        if(sortType.equals("DES")){
            sort = Sort.by(Sort.Direction.DESC);
        }else {
            sort = Sort.by(Sort.Direction.ASC);
        }
        Pageable pg= PageRequest.of(page,size,sort);

        return productCriteriaDAO.searchForProduct(searchReq, pg);
    }

    public Page<Product> getAllProductsWithSorting(SortReq sortReq, int page, int size, String sortType) {

        Sort sort;
        if(sortType.equals("DES")){
            sort = Sort.by(Sort.Direction.DESC);
        }else {
            sort = Sort.by(Sort.Direction.ASC);
        }
        Pageable pg= PageRequest.of(page,size,sort);

        return productCriteriaDAO.sortProducts(sortReq, pg);
    }


}
