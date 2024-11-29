package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Table(name = "article")
public class Article {
    private Integer id;
    @Getter
    private String contenu;
    @Getter
    private String datePublication;
    private User auteur;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auteur")
    public User getAuteur() {
        return auteur;
    }
}
