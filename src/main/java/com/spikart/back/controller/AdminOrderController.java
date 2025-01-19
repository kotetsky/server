package com.spikart.back.controller;

import com.spikart.back.exception.OrderException;
import com.spikart.back.model.Order;
import com.spikart.back.response.ApiResponse;
import com.spikart.back.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/admin/orders")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAllOrdersHandler() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<List<Order>>(orders, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{orderId}/confirmed")
    public ResponseEntity<Order> confirmedOrderHandler(
            @PathVariable Long orderId, @RequestHeader(Const.AUTHORIZATION) String jwt
    )  throws OrderException {
        Order order = orderService.confirmedOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}/ship")
    public ResponseEntity<Order> shippedOrderHandler(
            @PathVariable Long orderId
    ) throws OrderException {
        Order order = orderService.shippedOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteOrderHandler(
            @PathVariable Long orderId,
            @RequestHeader(Const.AUTHORIZATION) String jwt
    ) throws OrderException {
        orderService.deleteOrder(orderId);
        ApiResponse result = new ApiResponse();
        result.setMessage("order deleted successfully");
        result.setStatus(true);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
