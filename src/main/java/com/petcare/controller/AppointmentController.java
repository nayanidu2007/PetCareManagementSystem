/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.controller;
import com.petcare.dao.AppointmentDAO;
import com.petcare.model.Apointment;

import java.util.List;

/**
 *
 * @author User
 */
public class AppointmentController {
      private final AppointmentDAO appointmentDAO;

    public AppointmentController() {

        appointmentDAO = new AppointmentDAO();
    }


    public boolean addAppointment(Apointment appointment) {

        return appointmentDAO.addAppointment(appointment);
    }


    public List<Apointment> getAllAppointments() {

        return appointmentDAO.getAllAppointments();
    }


    public Apointment getAppointmentById(int appointmentId) {

        return appointmentDAO.getAppointmentById(appointmentId);
    }


    public boolean updateAppointment(Apointment appointment) {

        return appointmentDAO.updateAppointment(appointment);
    }


    public boolean deleteAppointment(int appointmentId) {

        return appointmentDAO.deleteAppointment(appointmentId);
    }
    
}
