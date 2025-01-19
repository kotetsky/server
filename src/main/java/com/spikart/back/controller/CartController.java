package com.spikart.back.controller;

import com.spikart.back.exception.ProductException;
import com.spikart.back.exception.UserException;
import com.spikart.back.model.Cart;
import com.spikart.back.model.User;
import com.spikart.back.request.AddCartItemRequest;
import com.spikart.back.response.ApiResponse;
import com.spikart.back.service.CartService;
import com.spikart.back.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    @Operation(description = "find cart by user id")
    public ResponseEntity<Cart> findUserCart(
        @RequestHeader(Const.AUTHORIZATION) String jwt
    ) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());
        return new ResponseEntity<Cart>(cart,HttpStatus.OK);
    }

    @PutMapping("/add")
    @Operation(description = "add item to cart")
    public ResponseEntity<ApiResponse> addItemToCart(
            @RequestBody AddCartItemRequest request,
            @RequestHeader(Const.AUTHORIZATION) String jwt
    ) throws UserException, ProductException {
        User user = userService.findUserProfileByJwt(jwt);
        cartService.addCartItem(user.getId(), request);
        ApiResponse response = new ApiResponse();
        response.setStatus(true);
        response.setMessage("item has been added to cart");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
