package com.devtiro.blog.category;

import com.devtiro.blog.category.dtos.CategoryDto;
import com.devtiro.blog.category.dtos.CreateCategoryRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<Category> categories = categoryService.listCategories();

        //category -> categoryMapper.toDto(category)
        return ResponseEntity.ok(categories.stream().map(categoryMapper::toDto).toList());

    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){
        Category category = categoryMapper.toEntity(createCategoryRequest);

        Category savedCategory = categoryService.createCategory(category);

        return new ResponseEntity<>(
                categoryMapper.toDto(savedCategory),
                HttpStatus.CREATED //201 status for successful
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaregory(@PathVariable UUID id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
