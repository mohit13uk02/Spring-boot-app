package com.example.loginregisterapp.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.loginregisterapp.model.User;
import com.example.loginregisterapp.service.UserService;

import jakarta.validation.Valid;
 

@Controller 
public class HomeController {
	private final UserService userService;
	public HomeController(UserService userService) {
		this.userService=userService;
		
	}

    
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user,BindingResult result) {
        if(result.hasErrors()){
                 
            return "register";
        }
        userService.registerUser(user); 
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
}
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {
User user = userRepository.findByEmailAndPassword(email, password);
 if (user != null) {
            model.addAttribute("name", user.getUsername());
            return "welcome";
 } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
 }
    }
}
