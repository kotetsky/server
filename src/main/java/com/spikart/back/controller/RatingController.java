package com.spikart.back.controller;

import com.spikart.back.exception.ProductException;
import com.spikart.back.exception.UserException;
import com.spikart.back.model.Rating;
import com.spikart.back.model.User;
import com.spikart.back.request.RatingRequest;
import com.spikart.back.service.RatingService;
import com.spikart.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RatingController {

    @Autowired
    private UserService userService;

    @Autowired
    private RatingService ratingService;

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(
            @RequestBody RatingRequest request,
            @RequestHeader(Const.AUTHORIZATION) String jwt
    ) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        Rating rating = ratingService.createRating(request, user);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Rating>> getProductsRating(
            @PathVariable Long productId,
            @RequestHeader(Const.AUTHORIZATION) String jwt
    ) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        List<Rating> ratings = ratingService.getProductsRatings(productId);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }



}
