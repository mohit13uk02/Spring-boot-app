package com.example.loginregisterapp.controller;
import com.example.loginregisterapp.model.User;
import com.example.loginregisterapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;


@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result,Model model) {
        if(result.hasErrors()){
            if (result.hasFieldErrors("username")){
                model.addAttribute("usernameError",result.getFieldError("username").getDefaultMessage());
            }
            if(result.hasFieldErrors("email")){
                model.addAttribute("emailError",result.getFieldError("email").getDefaultMessage());
            }
                
            return "register";
        }
        userRepository.save(user);
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
