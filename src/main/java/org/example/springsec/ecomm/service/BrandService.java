package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.dto.ProductDto;
import org.example.springsec.ecomm.entity.Brand;
import org.example.springsec.ecomm.repo.BrandRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepo brandRepo;
    private final ProductService productService;

    public ResponseEntity<Void> addBrand(Brand brand){
        brandRepo.save(brand);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> deleteBrand(Long id){
        brandRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<ProductDto>> findProductsByBrandId(Long id){
        return ResponseEntity.ok(productService.getAllByBrandId(id));
    }
}
