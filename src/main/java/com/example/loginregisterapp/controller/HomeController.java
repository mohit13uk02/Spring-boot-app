package com.example.loginregisterapp.controller;

import com.example.loginregisterapp.model.User;
import com.example.loginregisterapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    // Register Page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    // Save User
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/login";
    }

    // Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // Login Logic
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