/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petcare.model;

/**
 *
 * @author User
 */
public class Veterinarian 
{
    private int veterinaryId;
    private String fullName;
    private String Phone;
    private String email;
    private String Specialization;
    
    //defaul constructor
    public Veterinarian()
{
    
}
    
    //constructor  without id
    
    public Veterinarian(String fullName, String phone, String email, String Specialization)
    {
        this.fullName=fullName;
        this.Phone=phone;
        this.email=email;
        this.Specialization=Specialization;
    }
    
    //constructor with id
        public Veterinarian( int veterinaryId, String fullName, String phone, String email, String Specialization)
    {
        this.veterinaryId=veterinaryId;
        this.fullName=fullName;
        this.Phone=phone;
        this.email=email;
        this.Specialization=Specialization;
    }
        
        //get ands set veterinaryId
        
        public int getveterinaryId()
        {
            return veterinaryId;
        }
        public void setveterinaryId(int veterinaryId)
        {
            this.veterinaryId=veterinaryId;
        }
        
        //get and set veterinary full name
        
        public String getfullName()
        {
            return fullName;
        }
        public void setfullName(String fullName)
        {this.fullName=fullName;}
        
        //get and set veterinary phone
        
        public String getPhone()
        {return Phone;}
        public void setPhone(String phone)
        {this.Phone=phone;}
        
        //get and set email
        
        public String getemail()
        {return email;}
        public void setemail(String email)
        {this.email=email;}
        
        //get and set veterinarian specialization
        
        public String getSpecialization()
        { return Specialization;
        }
        public void  setSpecialization (String Specialization)
        {this.Specialization= Specialization;}
        
        
    
    
}




