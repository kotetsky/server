package com.spikart.back.service;

import com.spikart.back.exception.ProductException;
import com.spikart.back.model.Rating;
import com.spikart.back.model.User;
import com.spikart.back.request.RatingRequest;

import java.util.List;

public interface RatingService {

    public Rating createRating(RatingRequest ratingRequest, User user) throws ProductException;

    public List<Rating> getProductsRatings(Long productId);
}
