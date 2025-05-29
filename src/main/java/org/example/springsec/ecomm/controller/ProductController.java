package org.example.springsec.ecomm.controller;

import lombok.AllArgsConstructor;
import org.example.springsec.ecomm.dto.ProductDto;
import org.example.springsec.ecomm.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public ResponseEntity<Void> postProductDto(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProductDto(@RequestParam("id") Long id) {
        return productService.deleteById(id);
    }

}
