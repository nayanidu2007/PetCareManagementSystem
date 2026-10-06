/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.dao;

import com.petcare.model.pet;
import com.petcare.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class petDAO 
{
   public boolean addPet(pet pet) {

        String sql = "INSERT INTO pets"
                +"(customer_id, pet_name, species, breed, gender, date_of_birth, weight)"
                +"VALUES (?,?,?,?,?,?,?)";


        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, pet.getcustomerId());
            statement.setString(2, pet.getpetName());
            statement.setString(3, pet.getspecies());
            statement.setString(4, pet.getbreed());
            statement.setString(5, pet.getgender());
            statement.setDate(6, pet.getdateOfBirth());
            statement.setDouble(7, pet.getweight());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
   //get pet by Id
   
   public pet getpetById(int petId)
   {
       String sql = "SELECT * FROM pets WHERE pet_id=?";
       
       try (Connection connection = DBConnection.getConnection();
               PreparedStatement statment = connection.prepareStatement(sql))
       {
           statment.setInt(1, petId);
           
           try(ResultSet resultSet = statment.executeQuery()){
               if (resultSet.next())
               {
                   pet pet =new pet();
                           
                   pet.setpetId(resultSet.getInt("pet_id"));
                   pet.setcustomerId(resultSet.getInt("customer_id"));
                   pet.setpetName(resultSet.getString("pet_name"));
                   pet.setspecies(resultSet.getString("species"));
                   pet.setbreed(resultSet.getString("breed"));
                   pet.setgender(resultSet.getString("gender"));
                   pet.setdateOfBirth(resultSet.getDate("date_of_birth"));
                   pet.setweight(resultSet.getDouble("weight"));  
                    
                   return pet;
               }
          
           }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }
       return null;
   }
   
   //update pet
   
  public boolean updatePet(pet pet) {

    String sql = "UPDATE pets SET "
            + "customer_id=?, "
            + "pet_name=?, "
            + "species=?, "
            + "breed=?, "
            + "gender=?, "
            + "date_of_birth=?, "
            + "weight=? "
            + "WHERE pet_id=?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, pet.getcustomerId());
        statement.setString(2, pet.getpetName());
        statement.setString(3, pet.getspecies());
        statement.setString(4, pet.getbreed());
        statement.setString(5, pet.getgender());
        statement.setDate(6, pet.getdateOfBirth());
        statement.setDouble(7, pet.getweight());
        statement.setInt(8, pet.getpetId());

        System.out.println("Executing UPDATE...");
        System.out.println("Pet ID = " + pet.getpetId());

        int rowsUpdate = statement.executeUpdate();

        System.out.println("Rows updated = " + rowsUpdate);

        return rowsUpdate > 0;

    } catch (SQLException e) {

        System.out.println("========== PET UPDATE SQL ERROR ==========");
        System.out.println("Message: " + e.getMessage());
        System.out.println("SQL State: " + e.getSQLState());
        System.out.println("Error Code: " + e.getErrorCode());
        e.printStackTrace();
        System.out.println("==========================================");

        return false;
    }
}
   // delete pet
   
  public boolean deletePet(int petId) {

    String sql = "DELETE FROM pets WHERE pet_id=?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, petId);

        int rowsDeleted = statement.executeUpdate();

        return rowsDeleted > 0;

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );

        return false;
    }
}
   // GET ALL PETS

public List<pet> getAllPets()
{
    List<pet> pets = new ArrayList<>();

    String sql = "SELECT * FROM pets ORDER BY pet_id DESC";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery())
    {
        while (resultSet.next())
        {
            pet pet = new pet();

            pet.setpetId(resultSet.getInt("pet_id"));
            pet.setcustomerId(resultSet.getInt("customer_id"));
            pet.setpetName(resultSet.getString("pet_name"));
            pet.setspecies(resultSet.getString("species"));
            pet.setbreed(resultSet.getString("breed"));
            pet.setgender(resultSet.getString("gender"));
            pet.setdateOfBirth(resultSet.getDate("date_of_birth"));
            pet.setweight(resultSet.getDouble("weight"));

            pets.add(pet);
        }
    }
    catch (SQLException e)
    {
        e.printStackTrace();
    }

    return pets;
}
    
      
    
    
}
