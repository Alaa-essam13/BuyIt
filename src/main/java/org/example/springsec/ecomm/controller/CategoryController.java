package org.example.springsec.ecomm.controller;

import lombok.AllArgsConstructor;
import org.example.springsec.ecomm.dto.CategoryDto;
import org.example.springsec.ecomm.service.CategoryService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/all")
    @Cacheable(value = "Categories")
    public ResponseEntity<List<CategoryDto>> getCategoryDto() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    @Cacheable(value = "Category",key = "#id")
    public ResponseEntity<CategoryDto> getCategoryDtoById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getById(id));
    }

    @PostMapping("/add")
    @CacheEvict(value = {"Categories","Category"},allEntries = true)
    public ResponseEntity<Void> putCategoryDto(@RequestBody CategoryDto categoryDto) {
        return categoryService.addCategory(categoryDto);
    }

}
