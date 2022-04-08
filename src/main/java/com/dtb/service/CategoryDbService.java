package com.dtb.service;

import com.dtb.domain.Category;
import com.dtb.exception.CategoryNotFoundException;
import com.dtb.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryDbService {
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(final Long id) {
        return categoryRepository.findById(id);
    }

    public Long findByName(final String name) throws CategoryNotFoundException {
        return categoryRepository.findByName(name).orElseThrow(CategoryNotFoundException::new).getId();
    }

    public String findNameById(final Long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new).getName();
    }

    public Category saveCategory(final Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(final Long id) {
        categoryRepository.deleteById(id);
    }
}
