package com.spikart.back.repository;

import com.spikart.back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);
}
