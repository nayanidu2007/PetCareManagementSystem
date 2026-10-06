/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.dao;

import com.petcare.model.Bill;
import com.petcare.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class BillDAO 
{
    public boolean addBill(Bill bill)
    {
  

        String sql = "INSERT INTO bills "
                + "(appointment_id, bill_date, total_amount, "
                + "payment_method, payment_status) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, bill.getAppointmentId());
            pst.setDate(2, bill.getBillDate());
            pst.setDouble(3, bill.getTotalAmount());
            pst.setString(4, bill.getPaymentMethod());
            pst.setString(5, bill.getPaymentStatus());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // GET ALL BILLS
    public List<Bill> getAllBills() {

        List<Bill> bills = new ArrayList<>();

        String sql = "SELECT * FROM bills ORDER BY bill_id DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                Bill bill = new Bill();

                bill.setBillId(rs.getInt("bill_id"));
                bill.setAppointmentId(rs.getInt("appointment_id"));
                bill.setBillDate(rs.getDate("bill_date"));
                bill.setTotalAmount(rs.getDouble("total_amount"));
                bill.setPaymentMethod(rs.getString("payment_method"));
                bill.setPaymentStatus(rs.getString("payment_status"));

                bills.add(bill);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bills;
    }


    // GET BILL BY ID
    public Bill getBillById(int billId) {

        String sql = "SELECT * FROM bills WHERE bill_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, billId);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                Bill bill = new Bill();

                bill.setBillId(rs.getInt("bill_id"));
                bill.setAppointmentId(rs.getInt("appointment_id"));
                bill.setBillDate(rs.getDate("bill_date"));
                bill.setTotalAmount(rs.getDouble("total_amount"));
                bill.setPaymentMethod(rs.getString("payment_method"));
                bill.setPaymentStatus(rs.getString("payment_status"));

                return bill;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // UPDATE BILL
    public boolean updateBill(Bill bill) {

        String sql = "UPDATE bills SET "
                + "appointment_id = ?, "
                + "bill_date = ?, "
                + "total_amount = ?, "
                + "payment_method = ?, "
                + "payment_status = ? "
                + "WHERE bill_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, bill.getAppointmentId());
            pst.setDate(2, bill.getBillDate());
            pst.setDouble(3, bill.getTotalAmount());
            pst.setString(4, bill.getPaymentMethod());
            pst.setString(5, bill.getPaymentStatus());
            pst.setInt(6, bill.getBillId());

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // DELETE BILL
    public boolean deleteBill(int billId) {

        String sql = "DELETE FROM bills WHERE bill_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setInt(1, billId);

            return pst.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
