package com.cybage.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Utility {
	
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/java_project";
		return DriverManager.getConnection(url,"root","Vishal@123");
	}


}
