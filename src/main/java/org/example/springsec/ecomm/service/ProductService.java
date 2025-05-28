package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.dto.ProductDto;
import org.example.springsec.ecomm.entity.Product;
import org.example.springsec.ecomm.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo  productRepo;

    public List<ProductDto> getAllByBrandId(Long brandId) {
        return productRepo.findByBrand_Id(brandId);
    }

    private Product getProduct(Long id) {
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

    public void addProduct(ProductDto productDto) {
        productRepo.save(Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .stock(productDto.getStock())
                .imageUrl(productDto.getImageUrl())
                .build());
    }

    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }




}
