package com.spikart.back.repository;

import com.spikart.back.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    /*
    @Query("SELECT c FROM Cart c WHERE c.userId = :userId")
    public Cart findByUserId(@Param("userId") Long fghfgh);
    */
}
