package org.example.springsec.ecomm.service;

import lombok.RequiredArgsConstructor;
import org.example.springsec.ecomm.dto.CategoryDto;
import org.example.springsec.ecomm.entity.Category;
import org.example.springsec.ecomm.repo.CategoryRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public List<CategoryDto> getAll(){
        return categoryRepo.findAll().stream()
                .map(c -> new CategoryDto(c.getName(), c.getDescription()))
                .toList();
    }

    public ResponseEntity<Void> addCategory(CategoryDto categoryDto) {

        if(categoryRepo.findByName(categoryDto.getName()) != null){
            Category.builder()
                    .name(categoryDto.getName())
                    .description(categoryDto.getDescription()).build();
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public CategoryDto getById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow();
        return CategoryDto.builder().name(category.getName()).description(category.getDescription()).build();
    }

}
