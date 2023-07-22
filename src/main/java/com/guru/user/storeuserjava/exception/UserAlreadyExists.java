package com.guru.user.storeuserjava.exception;

public class UserAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExists(String message) {
		super(message);
	}

}