/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.controller;
import com.petcare.dao.DashboardDAO;

/**
 *
 * @author User
 */
public class DashboardController {
      private final DashboardDAO dashboardDAO;

    public DashboardController() {
        dashboardDAO = new DashboardDAO();
    }

    public int getCustomerCount() {
        return dashboardDAO.getCustomerCount();
    }

    public int getPetCount() {
        return dashboardDAO.getPetCount();
    }

    public int getVeterinarianCount() {
        return dashboardDAO.getVeterinarianCount();
    }

    public int getAppointmentCount() {
        return dashboardDAO.getAppointmentCount();
    }

    public int getTreatmentCount() {
        return dashboardDAO.getTreatmentCount();
    }

    public int getBillCount() {
        return dashboardDAO.getBillCount();
    }
    
}
