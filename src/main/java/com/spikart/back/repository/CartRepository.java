package com.spikart.back.repository;

import com.spikart.back.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartRepository extends JpaRepository<Cart, Long> {

    // doesnt work and gives an error

    /*
    @Query("SELECT c FROM Cart c WHERE c.userId = :userId")
    public Cart findCartByUserId(@Param("userId") Long userId);
    */

}
