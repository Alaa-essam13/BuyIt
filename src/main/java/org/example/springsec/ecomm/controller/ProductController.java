package org.example.springsec.ecomm.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.example.springsec.ecomm.dto.ProductDto;
import org.example.springsec.ecomm.dto.SearchReq;
import org.example.springsec.ecomm.dto.SortReq;
import org.example.springsec.ecomm.entity.Product;
import org.example.springsec.ecomm.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @GetMapping("/brand/{id}")
    public ResponseEntity<List<ProductDto>> getProductDto(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getAllByBrandId(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> postProductDto(@RequestBody @Valid ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProductDto(@RequestParam("id") Long id) {
        return productService.deleteById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Product>> searchProducts(
            @RequestParam("search") String searchReq,
            @Min(0) @RequestParam(value = "page", defaultValue = "0") int page,
            @Min(1) @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "type", defaultValue = "asc") String sortType
            ) {
        Page<Product> products=productService.searchProducts(searchReq,page,size,sortType);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/sort")
    public ResponseEntity<Page<Product>> sortProducts(
            @RequestParam("field") String sortReq,
            @Min(0) @RequestParam(value = "page", defaultValue = "0") int page,
            @Min(1) @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "type", defaultValue = "asc") String sortType
            ) {
        Page<Product> products = productService.
                getAllProductsWithSorting(sortReq,page,size,sortType);
        return ResponseEntity.ok(products);
    }




}
