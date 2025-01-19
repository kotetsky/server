package com.spikart.back.controller;

import com.spikart.back.exception.ProductException;
import com.spikart.back.exception.UserException;
import com.spikart.back.model.Review;
import com.spikart.back.model.User;
import com.spikart.back.request.ReviewRequest;
import com.spikart.back.service.ReviewService;
import com.spikart.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(
            @RequestBody ReviewRequest request,
            @RequestHeader(Const.AUTHORIZATION) String jwt
    ) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        Review review = reviewService.createReview(request, user);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productID}")
    public ResponseEntity<List<Review>> getProductReview(
        @PathVariable Long productId
    ) throws UserException, ProductException {
        List<Review> reviews = reviewService.getAllReviews(productId);
        return new ResponseEntity<>(reviews, HttpStatus.CREATED);
    }
}
