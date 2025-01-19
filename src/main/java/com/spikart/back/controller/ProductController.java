package com.spikart.back.controller;

import com.spikart.back.exception.ProductException;
import com.spikart.back.model.Product;
import com.spikart.back.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all-products")
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

    @PostMapping("/create-product")
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


    // from Zosh ! end of 5 th video

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> findProductByCategoryHandler(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) List<String> color,
            @RequestParam(required = false) List<String> size,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice,
            @RequestParam(required = false) Integer minDiscount,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String stock,
            @RequestParam(required = false) Integer pageNumber,
            @RequestParam(required = false) Integer pageSize
    ) {
        Page<Product> res = productService.getAllProduct(category, color, size,
                minPrice, maxPrice, minDiscount, sort, stock, pageNumber, pageSize
        );
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @GetMapping("/products/id/{productId}")
    public ResponseEntity<Product> findProductByIdHandler(
            @PathVariable Long productId
    ) throws ProductException {
        Product product = productService.findProductById(productId);
        return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
    }


    // removed by Zosh because we will implement it later

    /*
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProductHandler(
            @RequestParam String q
    ) {
        List<Product> products = productService.searchProduct(q);
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
    */
}
