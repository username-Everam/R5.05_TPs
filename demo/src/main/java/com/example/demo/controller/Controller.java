package com.example.demo.controller;

import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private LikedRepository likedRepository;

    public Controller(UserRepository userRepository, ArticleRepository articleRepository) {
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping("/")
    public String index() {
        return "API is running!";
    }
    
    @PostMapping("/add_user")
    public @ResponseBody User addNewUser (@RequestParam String name, @RequestParam String password, @RequestParam String role) {
        User n = new User();
        n.setName(name);
        n.setPassword(password);
        n.setRole(Role.getRoleWithString(role));
        userRepository.save(n);
        return n;
    }

    @GetMapping("/all_users")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public @ResponseBody User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping("/modify_user")
    public @ResponseBody User modifyUser (@RequestParam Integer id, @RequestParam String name, @RequestParam String password, @RequestParam String role) {
        User n = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        n.setName(name);
        n.setPassword(password);
        n.setRole(Role.getRoleWithString(role));
        userRepository.save(n);
        return n;
    }

    @PostMapping("/delete_user")
    public @ResponseBody String deleteUser (@RequestParam Integer id) {
        userRepository.delete(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
        return "User deleted";
    }

    @PostMapping("/add_article")
    public @ResponseBody Article addNewArticle (@RequestParam String contenu, @RequestParam String datePublication, @RequestParam Integer auteur) {
        Article n = new Article();
        n.setContenu(contenu);
        n.setDatePublication(datePublication);
        n.setAuteur(userRepository.findById(auteur).orElseThrow(() -> new RuntimeException("User not found")));
        articleRepository.save(n);
        return n;
    }

    @GetMapping("/all_articles")
    public @ResponseBody Iterable<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/article/{id}")
    public @ResponseBody Article getArticle(@PathVariable Integer id) {
        return articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @PostMapping("/modify_article")
    public @ResponseBody Article modifyArticle (@RequestParam Integer id, @RequestParam String contenu, @RequestParam String datePublication, @RequestParam Integer auteur) {
        Article n = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
        n.setContenu(contenu);
        n.setDatePublication(datePublication);
        n.setAuteur(userRepository.findById(auteur).orElseThrow(() -> new RuntimeException("User not found")));
        articleRepository.save(n);
        return n;
    }

    @PostMapping("/delete_article")
    public @ResponseBody String deleteArticle (@RequestParam Integer id) {
        articleRepository.deleteById(id);
        return "Article deleted";
    }
}

