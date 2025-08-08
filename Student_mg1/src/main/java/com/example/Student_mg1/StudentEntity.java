package com.example.Student_mg1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
     int rollNo;
     String name;
     String address;
     String email;
     String mobileNumber;
     String standard;
     double marks;

    public StudentEntity() {}

    public StudentEntity(int rollNo, String name, String address, String email, String mobileNumber, String standard, double marks) 
    {
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.standard = standard;
        this.marks = marks;
    }

    public int getRollNo() 
    {
    	return rollNo;
    }
    public void setRollNo(int rollNo) 
    {
    	this.rollNo = rollNo; 
    }

    
    public String getName() 
    {
    	return name;
    }
    public void setName(String name) 
    {
    	this.name = name; 
    }
    

    public String getAddress() 
    {
    	return address; 
    }
    public void setAddress(String address) 
    {
    	this.address = address; 
    }

    
    public String getEmail() 
    {
    	return email; 
    }
    public void setEmail(String email) 
    {
    	this.email = email; 
    }
    

    public String getMobileNumber() 
    {
    	return mobileNumber; 
    }
    public void setMobileNumber(String mobileNumber) 
    {
    	this.mobileNumber = mobileNumber; 
    	}
    

    public String getStandard() 
    {
    	return standard; 
    }
    public void setStandard(String standard) 
    {
    	this.standard = standard; 
    }
    

    public double getMarks() 
    {
    	return marks; 
    }
    public void setMarks(double marks) 
    {
    	this.marks = marks; 
    }
}
