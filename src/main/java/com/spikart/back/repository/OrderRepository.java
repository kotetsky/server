package com.spikart.back.repository;

import com.spikart.back.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    /*
    @Query("SELECT o FROM Order o WHERE o.userId = :userId AND o.orderStatus IN ('PLACED', 'CONFIRMED', 'SHIPPED', 'DELIVERED')")
    List<Order> getUsersOrders(@Param("userId") Long userId);
    */
}
