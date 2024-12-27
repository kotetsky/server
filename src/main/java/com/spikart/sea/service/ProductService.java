package com.spikart.sea.service;

import com.spikart.sea.model.Product;
import com.spikart.sea.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    public List<Product> getNewProducts() {
        List<Product> products = productRepository.findTop12ByOrderByCreatedAtDesc();
        return products;
    }

    public List<Product> getProductByViews() {
        List<Product> products = productRepository.findTop12ByOrderByViewsDesc();
        return products;
    }

    public Product createProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        return productRepository.save(product);
    }

    public List<Product> findByNameContainingIgnoreCase (String searchTerm) {
        List<Product> productList = productRepository.findByNameContainingIgnoreCase(searchTerm);
         return productList;
    }
}
