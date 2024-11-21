package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BonjourController {

    @RequestMapping("/bonjour")
    public String accueil() {
        return "<h1>Bonjour à tous le monde !</h1>";
    }
}

