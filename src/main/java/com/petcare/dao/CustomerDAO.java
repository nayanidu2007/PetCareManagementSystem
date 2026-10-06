/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.dao;

import com.petcare.model.Customer;
import com.petcare.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CustomerDAO {

    //add cudtomer
    public boolean addCustomer(Customer customer) {

        String sql = "INSERT INTO customers "
                   + "(full_name, phone, email, address) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, customer.getFullName());
            statement.setString(2, customer.getPhone());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getAddress());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


 //get all customers
    public List<Customer> getAllCustomers() {

        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM customers ORDER BY customer_id DESC";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Customer customer = new Customer();

                customer.setCustomerId(
                        resultSet.getInt("customer_id")
                );

                customer.setFullName(
                        resultSet.getString("full_name")
                );

                customer.setPhone(
                        resultSet.getString("phone")
                );

                customer.setEmail(
                        resultSet.getString("email")
                );

                customer.setAddress(
                        resultSet.getString("address")
                );

                customers.add(customer);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return customers;
    }


   //get customer by id
    public Customer getCustomerById(int customerId) {

        String sql = "SELECT * FROM customers WHERE customer_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, customerId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    Customer customer = new Customer();

                    customer.setCustomerId(
                            resultSet.getInt("customer_id")
                    );

                    customer.setFullName(
                            resultSet.getString("full_name")
                    );

                    customer.setPhone(
                            resultSet.getString("phone")
                    );

                    customer.setEmail(
                            resultSet.getString("email")
                    );

                    customer.setAddress(
                            resultSet.getString("address")
                    );

                    return customer;
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    //update
    public boolean updateCustomer(Customer customer) {

        String sql = "UPDATE customers SET "
                   + "full_name = ?, "
                   + "phone = ?, "
                   + "email = ?, "
                   + "address = ? "
                   + "WHERE customer_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, customer.getFullName());
            statement.setString(2, customer.getPhone());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getAddress());
            statement.setInt(5, customer.getCustomerId());

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }


    //delete
    public boolean deleteCustomer(int customerId) {

        String sql = "DELETE FROM customers WHERE customer_id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, customerId);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
}
