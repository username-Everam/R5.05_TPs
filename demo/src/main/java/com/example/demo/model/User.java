package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Table(name = "user")
public class User {
    private Integer id;
    @Getter
    private String name;
    @Getter
    private String password;
    @Getter
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer getId() {
        return id;
    }
}
