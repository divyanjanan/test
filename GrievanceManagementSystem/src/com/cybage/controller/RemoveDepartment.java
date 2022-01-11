package com.cybage.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.service.AdminService;

/**
 * Servlet implementation class removeDepartment
 */
@WebServlet("/RemoveDepartment")
public class RemoveDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminService service;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init(ServletConfig config) throws ServletException {
		service=new AdminService();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		if(session.getAttribute("user")==null || session.getAttribute("role")!="admin") { 
			response.sendRedirect("../Register.jsp");
			}
	
			
		    String departmentName=request.getParameter("department_name").toString();
		    System.out.println(departmentName);
			String deptName=service.removeDepartment(departmentName);
			System.out.println(deptName+" remove successfully");
			response.setHeader("http://localhost:8081/GrievanceManagementSystem",request.getContextPath()+"/Welcome.jsp");
	

}
}