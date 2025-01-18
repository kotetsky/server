package com.spikart.back.service;

import com.spikart.back.exception.ProductException;
import com.spikart.back.model.Product;
import com.spikart.back.model.Review;
import com.spikart.back.model.User;
import com.spikart.back.repository.ProductRepository;
import com.spikart.back.repository.ReviewRepository;
import com.spikart.back.request.ReviewRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService {

    private ReviewRepository reviewRepository;
    private ProductService productService;

    private ProductRepository productRepository;

    public ReviewServiceImplementation(
            ReviewRepository reviewRepository,
            ProductService productService,
            ProductRepository productRepository
    ) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Override
    public Review createReview(ReviewRequest request, User user) throws ProductException {
        Long productId = request.getProductId();
        Product product = productService.findProductById(productId);


        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setReview(request.getReview());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }


    @Override
    public List<Review> getAllReviews(Long productId) {
        return reviewRepository.getAllProductsReviews(productId);
    }
}
