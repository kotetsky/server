package com.spikart.back.service;

import com.spikart.back.exception.ProductException;
import com.spikart.back.model.Review;
import com.spikart.back.model.User;
import com.spikart.back.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review createReview(ReviewRequest request, User user) throws ProductException;

    public List<Review> getAllReviews(Long productId);

}
