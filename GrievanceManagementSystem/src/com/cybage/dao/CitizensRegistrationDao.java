package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cybage.model.Citizens;
public class CitizensRegistrationDao {
	Connection connection;
	PreparedStatement statement;
	
	public String registerUser(Citizens citizens) throws ClassNotFoundException, SQLException
    {
		//String name,email,password,mobile,aadhaar,address,gender;
		//FullName,Email,Mobile,Aadhar,Address,Gender,Password;
        String name = citizens.getName();
        String email = citizens.getEmail();
        String password = citizens.getPassword();
        String mobile = citizens.getMobile();
        String aadhaar = citizens.getAadhaar();
        String address = citizens.getAddress();
        String gender = citizens.getGender();
        
        PreparedStatement preparedStatement = null;         
        try
        {
            String query = "insert into citizen(ct_name,ct_email,ct_password,ct_mobile,ct_aadhaar,ct_address,ct_gender) values (?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
            preparedStatement = connection.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, mobile);
            preparedStatement.setString(5, aadhaar);
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, gender);
            
            int i= preparedStatement.executeUpdate();
            
            if (i!=0)  //Just to ensure data has been inserted into the database
            return "SUCCESS"; 
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }       
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }
	
	
}
