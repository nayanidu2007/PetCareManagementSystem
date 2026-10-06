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
public class pet 
{
    private int petId;
    private int customerId;
    private String petName;
    private String species;
    private String breed;
    private String gender;
    private Date dateOfBirth;
    private double weight;
    
    
    //default constructor
    public pet()
    {
        
    }
    //PARAMETERIZED CONSTRUCTOR
    public pet(int petId, int customerId, String petName, String species, String breed, String gender, Date dateOfBirth, double weight)
    {
        this.petId=petId;
        this.customerId=customerId;
        this.petName=petName;
        this.species=species;
        this.breed=breed;
        this.gender=gender;
        this.dateOfBirth=dateOfBirth;
        this.weight=weight;
        
    }
    
    //geters and setters
    
    public int getpetId()
    {
        return petId;
    }
    public void setpetId(int petId)
    {
        this.petId=petId;
    }
    
    
    
    public int getcustomerId()
    {
        return customerId;
    }
    public void setcustomerId(int customerId)
    {
        this.customerId=customerId;
    }
    
    
    
    public String getpetName()
    {
        return petName;
    }
    public void setpetName(String petName)
    {
        this.petName=petName;
    }
    
    
    
    public String getspecies()
    {
        return species;
    }
    public void setspecies(String species)
    {
        this.species=species;
    }
    
    
    
    public String getbreed()
    {
        return breed;
    }
    public void setbreed(String breed)
    {
        this.breed=breed;
    }
    
    
      public String getgender()
    {
        return gender;
    }
    public void setgender(String gender)
    {
        this.gender=gender;
    }
    
    
    public Date getdateOfBirth()
    {
        return dateOfBirth;
    }
    public void setdateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth=dateOfBirth;
    }
    
    
    public double getweight()
    {
        return weight;
    }
    public void setweight(double weight)
    {
        this.weight=weight;
    }
    
    
    
    
}
