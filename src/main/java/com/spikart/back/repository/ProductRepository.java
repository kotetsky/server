package com.spikart.back.repository;

import com.spikart.back.model.Product;
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


    // Zosh old methods

    // discountedPrice
    @Query("SELECT p FROM Product p WHERE (p.category.name = :category OR :category = '') " +
            "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountedPrice BETWEEN :minPrice AND :maxPrice)) " +
            "AND (:minDiscount IS NULL OR p.discountPresent >= :minDiscount) " +
            "ORDER BY " +
            "CASE WHEN :sort = 'price_low' THEN p.discountedPrice END ASC, " +
            "CASE WHEN :sort = 'price_high' THEN p.discountedPrice END DESC")
    List<Product> filterProducts(
            @Param("category") String category,
            @Param("minPrice") Integer minPrice,
            @Param("maxPrice") Integer maxPrice,
            @Param("minDiscount") Integer minDiscount,
            @Param("sort") String sort
    );

    @Query("SELECT p FROM Product p WHERE p.id = :productId")
    public Product findProductById(@Param("productId") Long productId);

}
