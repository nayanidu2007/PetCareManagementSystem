/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.dao;
import com.petcare.model.User;
import com.petcare.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author User
 */
public class UserDAO {
    
    public User login(String username, String password) {

        String sql = "SELECT * FROM users "
                   + "WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setUserId(
                    rs.getInt("user_id")
                );

                user.setUsername(
                    rs.getString("username")
                );

                user.setPassword(
                    rs.getString("password")
                );

                user.setRole(
                    rs.getString("role")
                );

                user.setFullName(
                    rs.getString("full_name")
                );

                return user;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}
