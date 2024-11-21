package com.example.demo.model;

public enum Role {
    MODERATOR, PUBLISHER;

    public static Role getRoleWithString(String role) {
        return Role.valueOf(role);
    } 
}
