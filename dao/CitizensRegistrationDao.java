package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cybage.model.Citizens;
import com.cybage.utilities.Utility;
public class CitizensRegistrationDao {
	Connection connection;
	PreparedStatement statement;
	
	public String registerUser(Citizens citizens) throws ClassNotFoundException, SQLException
    {
		connection=Utility.fetchConnection();
		System.out.println(citizens);
		//String name,email,password,mobile,aadhaar,address,gender;
		//FullName,Email,Mobile,Aadhar,Address,Gender,Password;
        String name = citizens.getName();
        String email = citizens.getEmail();
        String password = citizens.getPassword();
        String mobile = citizens.getMobile();
        String aadhaar = citizens.getAadhaar();
        String address = citizens.getAddress();
        String gender = citizens.getGender();
        
		try (PreparedStatement statement = connection.prepareStatement("insert into citizen(ct_name,ct_email,ct_password,ct_mobile,ct_aadhaar,ct_address,ct_gender) values (?,?,?,?,?,?,?)");) {
			statement.setString(1, name);
            statement.setString(2, email);
            statement.setString(3, password);
            statement.setString(4, mobile);
            statement.setString(5, aadhaar);
            statement.setString(6, address);
            statement.setString(7, gender);
            statement.executeUpdate();
		}
        
        return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    }
	
	
}
