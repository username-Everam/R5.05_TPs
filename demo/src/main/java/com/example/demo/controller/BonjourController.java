package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.UserRepository;

@RestController
public class BonjourController {

    private UserRepository userRepository;

    public BonjourController() {
        this.userRepository = null;
    }
    
    @PostMapping("/add")
    public @ResponseBody User addNewUser (@RequestParam String name, @RequestParam String password, @RequestParam String role) {
        User n = new User();
        n.setName(name);
        n.setPassword(password);
        n.setRole(Role.getRoleWithString(role));
        return n;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}

