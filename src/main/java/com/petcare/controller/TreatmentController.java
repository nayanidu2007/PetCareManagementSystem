/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.controller;


import com.petcare.dao.TreatmentDAO;
import com.petcare.model.Treatment;

import java.util.List;
/**
 *
 * @author User
 */
public class TreatmentController 
{
  private final TreatmentDAO treatmentDAO;

    public TreatmentController() {
        treatmentDAO = new TreatmentDAO();
    }

    public boolean addTreatment(Treatment treatment) {
        return treatmentDAO.addTreatment(treatment);
    }

    public List<Treatment> getAllTreatments() {
        return treatmentDAO.getAllTreatments();
    }

    public Treatment getTreatmentById(int treatmentId) {
        return treatmentDAO.getTreatmentById(treatmentId);
    }

    public boolean updateTreatment(Treatment treatment) {
        return treatmentDAO.updateTreatment(treatment);
    }

    public boolean deleteTreatment(int treatmentId) {
        return treatmentDAO.deleteTreatment(treatmentId);
    }   
}
