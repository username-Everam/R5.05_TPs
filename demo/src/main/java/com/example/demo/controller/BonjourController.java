package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class BonjourController {

    @GetMapping("/bonjour")
    public String accueil() {
        return "test";
    }
}

