package com.spikart.back.service;

import com.spikart.back.exception.CartItemException;
import com.spikart.back.exception.UserException;
import com.spikart.back.model.Cart;
import com.spikart.back.model.CartItem;
import com.spikart.back.model.Product;

public interface CartItemService {

    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(
            Long userId,
            Long id,
            CartItem cartItem
    ) throws CartItemException, UserException;


    public CartItem isCartItemExists(Cart cart, Product product, String size, Long userId);

    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;

    public CartItem finCartItemById(Long cartItemId) throws CartItemException;

}
