package com.spikart.back.service;

import com.spikart.back.exception.ProductException;
import com.spikart.back.model.Product;
import com.spikart.back.model.Rating;
import com.spikart.back.model.User;
import com.spikart.back.repository.RatingRepository;
import com.spikart.back.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImplementation implements RatingService {

    private RatingRepository ratingRepository;
    private ProductService productService;

    public RatingServiceImplementation(RatingRepository ratingRepository, ProductService productService) {
        this.productService = productService;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(RatingRequest ratingRequest, User user) throws ProductException {
        Product product = productService.findProductById(ratingRequest.getProductId());
        Rating rating = new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(ratingRequest.getRating());
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductsRatings(Long productId) {

        return ratingRepository.getAllProductsRating(productId);
    }
}
