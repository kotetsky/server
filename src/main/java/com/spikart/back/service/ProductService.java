package com.spikart.back.service;

import com.spikart.back.exception.ProductException;
import com.spikart.back.model.Product;
import com.spikart.back.model.Size;
import com.spikart.back.repository.ProductRepository;
import com.spikart.back.request.CreateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductById(long id);

    public List<Product> getNewProducts();

    public List<Product> getProductByViews();

    public Product createProduct(Product product);

    public List<Product> findByNameContainingIgnoreCase (String searchTerm);

    Product createProduct(CreateProductRequest request);

    String deleteProduct(Long productId) throws ProductException;

    Product updateProduct(Long productId, Product requestedProduct) throws ProductException;

    Product findProductById(Long productId) throws ProductException;

    List<Product> findProductByCategory(String category);

    Page<Product> getAllProduct(
            String category, List<String> colors,
            List<String> sizes, Integer minPrice, Integer maxPrice,
            Integer minDiscount, String sort, String stock,
            Integer pageNumber, Integer pageSize
    );
}
