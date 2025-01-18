package com.spikart.back.service;

import com.spikart.back.exception.UserException;
import com.spikart.back.model.User;

public interface UserService {

	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;
	
	
}
