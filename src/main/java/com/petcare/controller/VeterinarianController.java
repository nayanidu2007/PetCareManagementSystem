/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.controller;

import com.petcare.dao.VeterinarianDAO;
import com.petcare.model.Veterinarian;

import java.util.List;
/**
 *
 * @author User
 */
public class VeterinarianController 
{
 
    private final VeterinarianDAO veterinarianDAO;
    public VeterinarianController()
    {
        veterinarianDAO = new VeterinarianDAO();
    }
    
    //Add
    
    public boolean addVeterinarian(Veterinarian veterinarian)
    {
        return veterinarianDAO.addVeterinarian(veterinarian);
    }
    
    //Get all
    public List<Veterinarian> getAllVeterinarian()
    {
        return veterinarianDAO.getAllVeterinarian();
    }
    
    //get by id 
    
    public Veterinarian getVeterinarianById(int veterinarianId)
    {
        return veterinarianDAO.getVeterinarianBYId(veterinarianId);
    }
    
    //update
    
    public boolean updateVeterinarian(Veterinarian veterinarian)
    {
        return veterinarianDAO.updateVeterinarian(veterinarian);
    }
    
    //delete
    
    public boolean deleteVeterinarian(int veterinarianId)
    {return veterinarianDAO.deleteVeterinarian(veterinarianId);}
    
}
