package com.guru.user.storeuserjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guru.user.storeuserjava.entity.User;
import com.guru.user.storeuserjava.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUser(@PathVariable @Valid Long id){
		User user =  userService.getUser(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody User user){
		User addUser = userService.addUser(user);
		return ResponseEntity.ok(addUser);
	}
}