package com.spikart.back.service;

import com.spikart.back.exception.ProductException;
import com.spikart.back.model.Cart;
import com.spikart.back.model.User;
import com.spikart.back.request.AddCartItemRequest;

public interface CartService {

    public Cart createCart(User user);

    public String addCartItem(Long userId, AddCartItemRequest request) throws ProductException;

    public Cart findUserCart(Long userId);


}
