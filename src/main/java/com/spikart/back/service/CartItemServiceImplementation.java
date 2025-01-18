package com.spikart.back.service;

import com.spikart.back.exception.CartItemException;
import com.spikart.back.exception.UserException;
import com.spikart.back.model.Cart;
import com.spikart.back.model.CartItem;
import com.spikart.back.model.Product;
import com.spikart.back.model.User;
import com.spikart.back.repository.CartItemRepository;
import com.spikart.back.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImplementation implements CartItemService {

    private CartItemRepository cartItemRepository;
    private UserService userService;
    private CartRepository cartRepository;

    public CartItemServiceImplementation(
            CartItemRepository cartItemRepository,
            UserService userService,
            CartRepository cartRepository
    ) {
        this.cartItemRepository = cartItemRepository;
        this.userService = userService;
        this.cartRepository = cartRepository;
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()* cartItem.getQuantity());

        CartItem createdCartItem = cartItemRepository.save(cartItem);
        return createdCartItem;
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
        CartItem item = finCartItemById(id);
        User user = userService.findUserById(userId);

        if (user.getId().equals(userId)) {
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getQuantity() * item.getProduct().getPrice());
            item.setDiscountedPrice(item.getQuantity() * item.getProduct().getDiscountedPrice());
        }
        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExists(Cart cart, Product product, String size, Long userId) {
        CartItem cartItem = cartItemRepository.isCartItemExists(cart, product, size, userId);
        return cartItem;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
        CartItem cartItem = finCartItemById(cartItemId);
        Long cartItemUserId = cartItem.getUserId();
        User user = userService.findUserById(cartItemUserId);

        User reqUser = userService.findUserById(userId);
        if (user.getId().equals(reqUser.getId())) {
            cartItemRepository.deleteById(cartItemId);
        } else {
            throw new UserException("you can't remove the item which belongs to another user");
        }
    }

    @Override
    public CartItem finCartItemById(Long cartItemId) throws CartItemException {
        Optional<CartItem> opt = cartItemRepository.findById(cartItemId);
        if (opt.isPresent()) {
            return opt.get();
        } else throw new CartItemException("can't find cart item with id = " + cartItemId);
    }
}
