package com.spikart.sea.repository;

import com.spikart.sea.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long> {

    @Query("SELECT p FROM Product p ORDER BY p.createdAt DESC")
    List<Product> findLatestProducts(Pageable pageable);

    List<Product> findTop12ByOrderByCreatedAtDesc();

    List<Product> findTop12ByOrderByViewsDesc();

    @Query(value = "SELECT * FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) LIMIT 5", nativeQuery = true)
    List<Product> findByNameContainingIgnoreCase(@Param("searchTerm") String searchTerm);
}
