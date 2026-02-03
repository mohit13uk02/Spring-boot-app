package com.example.loginregisterapp.service;

import com.example.loginregisterapp.model.User;

public interface UserService {
	void registerUser(User user);
	User loginUser(String email,String password);
}
	


