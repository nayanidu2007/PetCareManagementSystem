/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.dao;

import com.petcare.model.Treatment;
import com.petcare.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class TreatmentDAO 
{

      // ADD
    public boolean addTreatment(Treatment treatment) {

        String sql = "INSERT INTO treatments "
                + "(appointment_id, diagnosis, treatment_description, "
                + "medication, treatment_date, cost) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, treatment.getAppointmentId());
            statement.setString(2, treatment.getDiagnosis());
            statement.setString(3, treatment.getTreatmentDescription());
            statement.setString(4, treatment.getMedication());
            statement.setDate(5, treatment.getTreatmentDate());
            statement.setDouble(6, treatment.getCost());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // GET ALL
    public List<Treatment> getAllTreatments() {

        List<Treatment> treatments = new ArrayList<>();

        String sql = "SELECT * FROM treatments "
                + "ORDER BY treatment_id DESC";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Treatment treatment = new Treatment();

                treatment.setTreatmentId(
                        resultSet.getInt("treatment_id")
                );

                treatment.setAppointmentId(
                        resultSet.getInt("appointment_id")
                );

                treatment.setDiagnosis(
                        resultSet.getString("diagnosis")
                );

                treatment.setTreatmentDescription(
                        resultSet.getString("treatment_description")
                );

                treatment.setMedication(
                        resultSet.getString("medication")
                );

                treatment.setTreatmentDate(
                        resultSet.getDate("treatment_date")
                );

                treatment.setCost(
                        resultSet.getDouble("cost")
                );

                treatments.add(treatment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return treatments;
    }


    // GET BY ID
    public Treatment getTreatmentById(int treatmentId) {

        String sql = "SELECT * FROM treatments "
                + "WHERE treatment_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, treatmentId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    Treatment treatment = new Treatment();

                    treatment.setTreatmentId(
                            resultSet.getInt("treatment_id")
                    );

                    treatment.setAppointmentId(
                            resultSet.getInt("appointment_id")
                    );

                    treatment.setDiagnosis(
                            resultSet.getString("diagnosis")
                    );

                    treatment.setTreatmentDescription(
                            resultSet.getString("treatment_description")
                    );

                    treatment.setMedication(
                            resultSet.getString("medication")
                    );

                    treatment.setTreatmentDate(
                            resultSet.getDate("treatment_date")
                    );

                    treatment.setCost(
                            resultSet.getDouble("cost")
                    );

                    return treatment;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    // UPDATE
    public boolean updateTreatment(Treatment treatment) {

        String sql = "UPDATE treatments SET "
                + "appointment_id = ?, "
                + "diagnosis = ?, "
                + "treatment_description = ?, "
                + "medication = ?, "
                + "treatment_date = ?, "
                + "cost = ? "
                + "WHERE treatment_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, treatment.getAppointmentId());
            statement.setString(2, treatment.getDiagnosis());
            statement.setString(3, treatment.getTreatmentDescription());
            statement.setString(4, treatment.getMedication());
            statement.setDate(5, treatment.getTreatmentDate());
            statement.setDouble(6, treatment.getCost());
            statement.setInt(7, treatment.getTreatmentId());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // DELETE
    public boolean deleteTreatment(int treatmentId) {

        String sql = "DELETE FROM treatments "
                + "WHERE treatment_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, treatmentId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
}
