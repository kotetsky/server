package com.spikart.back.service;

import com.spikart.back.exception.ProductException;
import com.spikart.back.model.Cart;
import com.spikart.back.model.CartItem;
import com.spikart.back.model.Product;
import com.spikart.back.model.User;
import com.spikart.back.repository.CartRepository;
import com.spikart.back.request.AddCartItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImplementation implements CartService {

    private CartRepository cartRepository;
    private CartItemService cartItemService;

    private ProductService productService;


    public CartServiceImplementation(
            CartRepository cartRepository,
            CartItemService cartItemService,
            ProductService productService
    ) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }


    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AddCartItemRequest request) throws ProductException {
        // Cart cart = cartRepository.findByUserId(userId);

        Cart cart = new Cart();
        Product product = productService.findProductById(request.getProductId());
        CartItem isPresent = cartItemService.isCartItemExists(cart, product, request.getSize(), userId);
        if (isPresent == null) {
            CartItem item = new CartItem();
            item.setProduct(product);
            item.setCart(cart);
            item.setQuantity(request.getQuantity());
            item.setUserId(userId);

            int price = request.getQuantity() * product.getDiscountedPrice();
            cart.setTotalPrice(price);
            item.setSize(request.getSize());

            CartItem createdCartItem = cartItemService.createCartItem(item);
            cart.getCartItems().add(createdCartItem);
        } else {

        }
        return "item is successfully added to cart";
    }

    @Override
    public Cart findUserCart(Long userId) {
        // Cart cart = cartRepository.findByUserId(userId);
        Cart cart = new Cart();

        int totalPrice = 0;
        int totalDiscountedPrice = 0;
        int totalItem = 0;

        for (CartItem item : cart.getCartItems()) {
            totalPrice = totalPrice + item.getPrice();
            totalDiscountedPrice = totalDiscountedPrice + item.getDiscountedPrice();
            totalItem = totalItem + item.getQuantity();
        }
        cart.setTotalPrice(totalPrice);
        cart.setTotalDiscountPrice(totalDiscountedPrice);
        cart.setDiscount(totalPrice - totalDiscountedPrice);
        cart.setTotalItem(totalItem);
        return cartRepository.save(cart);

    }
}
