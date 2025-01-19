package com.spikart.back.controller;

import com.spikart.back.exception.ProductException;
import com.spikart.back.model.Product;
import com.spikart.back.request.CreateProductRequest;
import com.spikart.back.response.ApiResponse;
import com.spikart.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(
            @RequestBody CreateProductRequest request
    ){
        Product product = productService.createProduct(request);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(
            @PathVariable Long productId
    ) throws ProductException {
        productService.deleteProduct(productId);
        ApiResponse response = new ApiResponse();
        response.setMessage("Product deleted successfully");
        response.setStatus(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/{productId}/update")
    public ResponseEntity<Product> updateProduct(
            @RequestBody Product requestedProduct, @PathVariable Long productId
    ) throws ProductException {
        Product product = productService.updateProduct(productId, requestedProduct);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }

    @PostMapping("/creates")
    public ResponseEntity<ApiResponse> createMultipleProducts(
        @RequestBody CreateProductRequest[] requestProducts
    ) {
        for (CreateProductRequest product : requestProducts) {
            productService.createProduct(product);
        }
        ApiResponse response = new ApiResponse();
        response.setStatus(true);
        response.setMessage("bunch of products created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
