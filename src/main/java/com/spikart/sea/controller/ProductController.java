package com.spikart.sea.controller;

import com.spikart.sea.model.Product;
import com.spikart.sea.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/most-visited")
    public ResponseEntity<List<Product>> getMostVisitedProducts() {
        List<Product> productList = productService.getProductByViews();
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(
                productList,
                HttpStatus.OK
        );
        return responseEntity;
    }

    @GetMapping("/new-coming")
    public ResponseEntity<List<Product>> getNewProducts() {
        List<Product> productList = productService.getNewProducts();
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(
                productList,
                HttpStatus.OK
        );
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
                createdProduct,
                HttpStatus.CREATED
        );
        return responseEntity;
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam("q") String query) {
        return productService.findByNameContainingIgnoreCase(query);
    }
}
