/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.dao;

import com.petcare.model.Veterinarian;
import com.petcare.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianDAO {

   //add
    public boolean addVeterinarian(Veterinarian veterinarian) {

        String sql = "INSERT INTO veterinarians "
                   + "(full_name, phone, email, specialization) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(1, veterinarian.getfullName());
            statement.setString(2, veterinarian.getPhone());
            statement.setString(3, veterinarian.getemail());
            statement.setString(4, veterinarian.getSpecialization());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


    // =========================
    // GET ALL VETERINARIANS
    // =========================
    public List<Veterinarian> getAllVeterinarian() {

        List<Veterinarian> veterinarians = new ArrayList<>();

        String sql = "SELECT * FROM veterinarians "
                   + "ORDER BY veterinarian_id DESC";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Veterinarian veterinarian =
                        new Veterinarian();

                veterinarian.setveterinaryId(
                        resultSet.getInt("veterinarian_id")
                );

                veterinarian.setfullName(
                        resultSet.getString("full_name")
                );

                veterinarian.setPhone(
                        resultSet.getString("phone")
                );

                veterinarian.setemail(
                        resultSet.getString("email")
                );

                veterinarian.setSpecialization(
                        resultSet.getString("specialization")
                );

                veterinarians.add(veterinarian);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return veterinarians;
    }


  //get all
    public Veterinarian getVeterinarianBYId(int veterinarianId) {

        String sql = "SELECT * FROM veterinarians "
                   + "WHERE veterinarian_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, veterinarianId);

            try (ResultSet resultSet =
                         statement.executeQuery()) {

                if (resultSet.next()) {

                    Veterinarian veterinarian =
                            new Veterinarian();

                    veterinarian.setveterinaryId(
                            resultSet.getInt("veterinarian_id")
                    );

                    veterinarian.setfullName(
                            resultSet.getString("full_name")
                    );

                    veterinarian.setPhone(
                            resultSet.getString("phone")
                    );

                    veterinarian.setemail(
                            resultSet.getString("email")
                    );

                    veterinarian.setSpecialization(
                            resultSet.getString("specialization")
                    );

                    return veterinarian;
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

//update
    public boolean updateVeterinarian(
            Veterinarian veterinarian) {

        String sql = "UPDATE veterinarians SET "
                   + "full_name = ?, "
                   + "phone = ?, "
                   + "email = ?, "
                   + "specialization = ? "
                   + "WHERE veterinarian_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setString(
                    1,
                    veterinarian.getfullName()
            );

            statement.setString(
                    2,
                    veterinarian.getPhone()
            );

            statement.setString(
                    3,
                    veterinarian.getemail()
            );

            statement.setString(
                    4,
                    veterinarian.getSpecialization()
            );

            statement.setInt(
                    5,
                    veterinarian.getveterinaryId()
            );

            int rowsUpdated =
                    statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


  //delete
    public boolean deleteVeterinarian(
            int veterinarianId) {

        String sql = "DELETE FROM veterinarians "
                   + "WHERE veterinarian_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, veterinarianId);

            int rowsDeleted =
                    statement.executeUpdate();

            return rowsDeleted > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
}