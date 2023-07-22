package com.guru.user.storeuserjava.service;

import com.guru.user.storeuserjava.entity.User;

public interface UserService {
	
	public User addUser(User user);

	public User getUser(Long id);

}