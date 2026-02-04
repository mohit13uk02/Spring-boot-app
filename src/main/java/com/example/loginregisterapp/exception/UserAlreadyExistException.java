package com.example.loginregisterapp.exception;

public class UserAlreadyExistException extends RuntimeException {
	public UserAlreadyExistException(String message) {
		super(message);
	}

}
