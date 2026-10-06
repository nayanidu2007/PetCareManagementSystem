/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.dao;
import com.petcare.model.Apointment;
import com.petcare.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author User
 */
public class AppointmentDAO {
     // ADD APPOINTMENT
    public boolean addAppointment(Apointment appointment) {

        String sql = "INSERT INTO appointments "
                   + "(pet_id, veterinarian_id, appointment_date, "
                   + "appointment_time, reason, status, notes) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, appointment.getPetId());
            statement.setInt(2, appointment.getVeterinarianId());
            statement.setDate(3, appointment.getAppointmentDate());
            statement.setTime(4, appointment.getAppointmentTime());
            statement.setString(5, appointment.getReason());
            statement.setString(6, appointment.getStatus());
            statement.setString(7, appointment.getNotes());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


    // GET ALL APPOINTMENTS
    public List<Apointment> getAllAppointments() {

        List<Apointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointments "
                   + "ORDER BY appointment_id DESC";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Apointment appointment = new Apointment();

                appointment.setAppointmentId(
                        resultSet.getInt("appointment_id"));

                appointment.setPetId(
                        resultSet.getInt("pet_id"));

                appointment.setVeterinarianId(
                        resultSet.getInt("veterinarian_id"));

                appointment.setAppointmentDate(
                        resultSet.getDate("appointment_date"));

                appointment.setAppointmentTime(
                        resultSet.getTime("appointment_time"));

                appointment.setReason(
                        resultSet.getString("reason"));

                appointment.setStatus(
                        resultSet.getString("status"));

                appointment.setNotes(
                        resultSet.getString("notes"));

                appointments.add(appointment);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return appointments;
    }


    // GET APPOINTMENT BY ID
    public Apointment getAppointmentById(int appointmentId) {

        String sql = "SELECT * FROM appointments "
                   + "WHERE appointment_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, appointmentId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    Apointment appointment = new Apointment();

                    appointment.setAppointmentId(
                            resultSet.getInt("appointment_id"));

                    appointment.setPetId(
                            resultSet.getInt("pet_id"));

                    appointment.setVeterinarianId(
                            resultSet.getInt("veterinarian_id"));

                    appointment.setAppointmentDate(
                            resultSet.getDate("appointment_date"));

                    appointment.setAppointmentTime(
                            resultSet.getTime("appointment_time"));

                    appointment.setReason(
                            resultSet.getString("reason"));

                    appointment.setStatus(
                            resultSet.getString("status"));

                    appointment.setNotes(
                            resultSet.getString("notes"));

                    return appointment;
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // UPDATE APPOINTMENT
    public boolean updateAppointment(Apointment appointment) {

        String sql = "UPDATE appointments SET "
                   + "pet_id = ?, "
                   + "veterinarian_id = ?, "
                   + "appointment_date = ?, "
                   + "appointment_time = ?, "
                   + "reason = ?, "
                   + "status = ?, "
                   + "notes = ? "
                   + "WHERE appointment_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, appointment.getPetId());
            statement.setInt(2, appointment.getVeterinarianId());
            statement.setDate(3, appointment.getAppointmentDate());
            statement.setTime(4, appointment.getAppointmentTime());
            statement.setString(5, appointment.getReason());
            statement.setString(6, appointment.getStatus());
            statement.setString(7, appointment.getNotes());
            statement.setInt(8, appointment.getAppointmentId());

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


    // DELETE APPOINTMENT
  public boolean deleteAppointment(int appointmentId) {

    String sql = "DELETE FROM appointments "
               + "WHERE appointment_id = ?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement =
                 connection.prepareStatement(sql)) {

        statement.setInt(1, appointmentId);

        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );

        e.printStackTrace();

        return false;
    }
}
}
