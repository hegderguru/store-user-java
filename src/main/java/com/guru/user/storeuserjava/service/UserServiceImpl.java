package com.guru.user.storeuserjava.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guru.user.storeuserjava.entity.User;
import com.guru.user.storeuserjava.exception.UserAlreadyExists;
import com.guru.user.storeuserjava.exception.UserNotFoundException;
import com.guru.user.storeuserjava.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		Optional<User> user1 = userRepository.findByUsername(user.getUsername());
		if(user1.isPresent()) {
			throw new UserAlreadyExists("User already exists");
		}
		else {
			userRepository.save(user);
		}
		
		return user;
	}

	@Override
	public User getUser(Long id) {
		Optional<User> findById = userRepository.findById(id);
		return findById.orElseThrow(() -> new UserNotFoundException("User not found"));
	}
	
	
}