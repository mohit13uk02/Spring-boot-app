package com.example.loginregisterapp.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public String handleEmailException(EmailAlreadyExistsException ex, Model model){
		model.addAttribute("exception",ex.getMessage());
		return "register";
	}
 
}
