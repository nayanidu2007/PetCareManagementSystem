/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.model;

import java.sql.Date;

/**
 *
 * @author User
 */
public class Treatment {
      private int treatmentId;
    private int appointmentId;
    private String diagnosis;
    private String treatmentDescription;
    private String medication;
    private Date treatmentDate;
    private double cost;

    public Treatment() {
    }

    public Treatment(
            int appointmentId,
            String diagnosis,
            String treatmentDescription,
            String medication,
            Date treatmentDate,
            double cost) {

        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.treatmentDescription = treatmentDescription;
        this.medication = medication;
        this.treatmentDate = treatmentDate;
        this.cost = cost;
    }

    public Treatment(
            int treatmentId,
            int appointmentId,
            String diagnosis,
            String treatmentDescription,
            String medication,
            Date treatmentDate,
            double cost) {

        this.treatmentId = treatmentId;
        this.appointmentId = appointmentId;
        this.diagnosis = diagnosis;
        this.treatmentDescription = treatmentDescription;
        this.medication = medication;
        this.treatmentDate = treatmentDate;
        this.cost = cost;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatmentDescription() {
        return treatmentDescription;
    }

    public void setTreatmentDescription(String treatmentDescription) {
        this.treatmentDescription = treatmentDescription;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public Date getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
}
