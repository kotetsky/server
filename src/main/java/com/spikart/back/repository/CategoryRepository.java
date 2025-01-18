package com.spikart.back.repository;

import com.spikart.back.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    // not working no maybe consider to remove. I like to have parent_id for category but Zosh made it another way
    // public List<Category> findAllByParentId(Long parentId);

    public Category findCategoryById(Long id);



    // Zosh old methods

    public Category findByName(String name);

    @Query("SELECT c FROM Category c " +
            "WHERE c.name = :name AND c.parentCategory.name = :parentCategoryName"
    )
    public Category findByNameAndParent(
            @Param("name") String name,
            @Param("parentCategoryName") String parentCategoryName
    );
}
