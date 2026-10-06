/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.controller;
import com.petcare.dao.UserDAO;
import com.petcare.model.User;

/**
 *
 * @author User
 */
public class UserController {
      private final UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
    }

    public User login(String username, String password) {

        return userDAO.login(username, password);
    }
}
