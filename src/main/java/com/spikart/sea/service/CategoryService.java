package com.spikart.sea.service;

import com.spikart.sea.model.Category;
import com.spikart.sea.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    public Category getCategoryById(Long id) {
        Optional<Category> optCategory = categoryRepository.findById(id);
        return optCategory.orElse(null);
    }

    public List<Category> getCategoriesByParentId(Long parentId) {
        List<Category> categories = categoryRepository.findAllByParentId(parentId);
        return categories;
    }
}
