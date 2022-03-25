package com.dtb.controller;

import com.dtb.domain.Category;
import com.dtb.domain.CategoryDto;
import com.dtb.exception.CategoryNotFoundException;
import com.dtb.exception.UserNotFoundException;
import com.dtb.mapper.CategoryMapper;
import com.dtb.service.CategoryDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("v1")
public class CategoryController {
    private final CategoryDbService categoryDbService;
    private final CategoryMapper categoryMapper;

    @GetMapping(value = "/categories")
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryDbService.getCategories();
        return categoryMapper.mapToCategoryDtoList(categories);
    }

    @GetMapping(value = "/categories/{id}")
    public CategoryDto getCategory(@PathVariable Long id) throws CategoryNotFoundException {
        return categoryMapper.mapToCategoryDto(
                categoryDbService.getCategory(id).orElseThrow(CategoryNotFoundException::new)
        );
    }

    @DeleteMapping(value = "categories/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryDbService.deleteCategory(id);
    }

    @PostMapping(value = "categories", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCategory(@RequestBody CategoryDto categoryDto) throws UserNotFoundException {
        Category category = categoryMapper.mapToCategory(categoryDto);
        categoryDbService.saveCategory(category);
    }

    @PutMapping(value = "categories")
    public CategoryDto updateCategory(@RequestBody CategoryDto categoryDto) throws UserNotFoundException {
        Category category = categoryMapper.mapToCategory(categoryDto);
        Category updatedCategory = categoryDbService.saveCategory(category);
        return categoryMapper.mapToCategoryDto(updatedCategory);
    }
}

