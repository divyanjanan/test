package com.cybage.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.dao.CitizensRegistrationDao;

import com.cybage.model.Citizens;

/**
 * Servlet implementation class CitizensRegistration
 */
@WebServlet("/CitizensRegistration")
public class CitizensRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CitizensRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//FullName,Email,Mobile,Aadhar,Address,Gender,Password;
    	//Copying all the input parameters in to local variables
		//String name,email,password,mobile,aadhaar,address,gender;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        String aadhaar = request.getParameter("aadhaar");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        
        
        
        Citizens citizens = new Citizens();
       //Using Java Beans - An easiest way to play with group of related data
      //String name,email,password,mobile,aadhaar,address,gender;
        citizens.setName(name);
        citizens.setEmail(email);
        citizens.setPassword(password);
        citizens.setMobile(mobile); 
        citizens.setAadhaar(aadhaar);
        citizens.setAddress(address);
        citizens.setGender(gender); 
        
        CitizensRegistrationDao registerDao = new CitizensRegistrationDao();
        
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.
        String userRegistered;
		try {
			userRegistered = registerDao.registerUser(citizens);
			if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
	        {
	           request.getRequestDispatcher("Login.jsp").forward(request, response);
	        }
	        else   //On Failure, display a meaningful message to the User.
	        {
	           request.setAttribute("errMessage", userRegistered);
	           request.getRequestDispatcher("/Register.jsp").forward(request, response);
	        }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
	}

}
