/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.dao;
import com.petcare.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class DashboardDAO {
    public int getCustomerCount() {
        return getCount("customers");
    }

    public int getPetCount() {
        return getCount("pets");
    }

    public int getVeterinarianCount() {
        return getCount("veterinarians");
    }

    public int getAppointmentCount() {
        return getCount("appointments");
    }

    public int getTreatmentCount() {
        return getCount("treatments");
    }

    public int getBillCount() {
        return getCount("bills");
    }


    private int getCount(String tableName) {

        String sql = "SELECT COUNT(*) FROM " + tableName;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    
}
