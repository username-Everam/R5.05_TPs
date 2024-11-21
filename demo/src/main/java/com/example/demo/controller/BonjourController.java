package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("bonjour")
public class BonjourController {

    @GetMapping
    public String accueil(Model model) {
        return "bonjour";
    }
}

