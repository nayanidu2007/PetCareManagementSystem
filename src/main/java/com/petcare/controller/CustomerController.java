/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.controller;

import com.petcare.dao.CustomerDAO;
import com.petcare.model.Customer;
import java.util.List;

/**
 *
 * @author User
 */
public class CustomerController 
{
    private final CustomerDAO customerDAO;
    
    public CustomerController()
    {
        customerDAO = new CustomerDAO();
    }
    public boolean addCustomer (Customer customer)
    {
        return customerDAO.addCustomer(customer);
    }
    
    public List<Customer>getAllCustomers()
    {
        return customerDAO.getAllCustomers();
    }
    
    public Customer getCustomerById(int customerId)
    {
        return customerDAO.getCustomerById(customerId);
    }
    
    public boolean updateCustomer(Customer customer)
    {
        return customerDAO.updateCustomer(customer);
    }
    
    public boolean deleteCustomer(int customerId)
    {
        return customerDAO.deleteCustomer(customerId);
    }
    
    
}
