/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.controller;

import com.petcare.dao.petDAO;
import com.petcare.model.pet;
import java.util.List;

/**
 *
 * @author User
 */
public class PetController 
{
     private final petDAO petDAO;
    
    public PetController()
    {
        petDAO = new petDAO();
    }
    public boolean addPet (pet pet)
    {
        return petDAO.addPet(pet);
    }
    
    public List<pet>getAllpets()
    {
        return petDAO.getAllPets();
    }
    
    public pet getpetById(int petId)
    {
        return petDAO.getpetById(petId);
    }
    
   public boolean updatePet(pet pet) {

    System.out.println("========== CONTROLLER UPDATE ==========");
    System.out.println("Pet ID: " + pet.getpetId());
    System.out.println("Customer ID: " + pet.getcustomerId());
    System.out.println("Pet Name: " + pet.getpetName());
    System.out.println("Species: " + pet.getspecies());
    System.out.println("Breed: " + pet.getbreed());
    System.out.println("Gender: " + pet.getgender());
    System.out.println("DOB: " + pet.getdateOfBirth());
    System.out.println("Weight: " + pet.getweight());

    boolean result = petDAO.updatePet(pet);

    System.out.println("DAO returned: " + result);
    System.out.println("========================================");

    return result;
}
    
    public boolean deletePet(int petId)
    {
        return petDAO.deletePet(petId);
    }
    
}
