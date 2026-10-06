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
public class Bill 
{
      private int billId;
    private int appointmentId;
    private Date billDate;
    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;

    // Default constructor
    public Bill() {
    }

    // Constructor without ID
    public Bill(int appointmentId, Date billDate, double totalAmount,
                String paymentMethod, String paymentStatus) {

        this.appointmentId = appointmentId;
        this.billDate = billDate;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Constructor with ID
    public Bill(int billId, int appointmentId, Date billDate,
                double totalAmount, String paymentMethod,
                String paymentStatus) {

        this.billId = billId;
        this.appointmentId = appointmentId;
        this.billDate = billDate;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    } 
}
