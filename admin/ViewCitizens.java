package com.cybage.controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.model.Citizens;
import com.cybage.service.AdminService;

/**
 * Servlet implementation class ViewCitizens
 */
@WebServlet("/admin/ViewCitizens")
public class ViewCitizens extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 AdminService service;  
	    
	    public ViewCitizens() {
	        super();
	        
	        service= new AdminService();
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session= request.getSession();
			if(session.getAttribute("user")==null || session.getAttribute("role")!="admin") { 
				response.sendRedirect("../Register.jsp");
				}
			// TODO Auto-generated method stub
			ArrayList<Citizens> citizens=(ArrayList<Citizens>) service.citizensList();
			System.out.println(session.getAttribute("user"));
			citizens.forEach(i->System.out.println(i));
			session.setAttribute("citizenList",citizens);
			RequestDispatcher dispatcher= request.getRequestDispatcher("viewCitizen.jsp");
			dispatcher.include(request, response);
		}
}
