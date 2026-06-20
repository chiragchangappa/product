package com.abc.testapp.controller;


import com.abc.testapp.entity.User;
import com.abc.testapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {

        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {

        userService.register(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {

        return "login";
    }
}