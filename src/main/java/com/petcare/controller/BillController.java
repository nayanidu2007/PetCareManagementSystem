/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.controller;
import com.petcare.dao.BillDAO;
import com.petcare.model.Bill;

import java.util.List;


/**
 *
 * @author User
 */
public class BillController 
{
      private final BillDAO billDAO;

    public BillController() {
        billDAO = new BillDAO();
    }

    public boolean addBill(Bill bill) {
        return billDAO.addBill(bill);
    }

    public List<Bill> getAllBills() {
        return billDAO.getAllBills();
    }

    public Bill getBillById(int billId) {
        return billDAO.getBillById(billId);
    }

    public boolean updateBill(Bill bill) {
        return billDAO.updateBill(bill);
    }

    public boolean deleteBill(int billId) {
        return billDAO.deleteBill(billId);
    }
    
}
