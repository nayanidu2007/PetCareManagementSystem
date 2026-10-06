/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.model;

/**
 *
 * @author User
 */
public class User {
     private int userId;
    private String username;
    private String password;
    private String role;
    private String fullName;

    // Default constructor
    public User() {
    }

    // Constructor without ID
    public User(String username, String password,
                String role, String fullName) {

        this.username = username;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
    }

    // Constructor with ID
    public User(int userId, String username,
                String password, String role,
                String fullName) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
