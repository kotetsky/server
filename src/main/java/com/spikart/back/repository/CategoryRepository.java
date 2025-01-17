package com.spikart.back.repository;

import com.spikart.back.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findAllByParentId(Long parentId);

    public Category findCategoryById(Long id);
}
