package com.example.loginregisterapp.service;

import org.springframework.stereotype.Service;

import com.example.loginregisterapp.model.User;
import com.example.loginregisterapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
				
	}
	@Override
	public void registerUser(User user) {
		if(userRepository.existsByEmail(user.getEmail())){
			throw new RuntimeException("Email already exists");
		}
		userRepository.save(user);
		
	}
	@Override
	public User loginUser(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
 
}
   
