package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String loginForm() {
        return "index";
    }

    @PostMapping("/index")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("user", user);
            return "home"; // redirect to home if success
        }

        model.addAttribute("error", "Invalid credentials");
        return "index";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
