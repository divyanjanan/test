package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.model.Department;
import com.cybage.service.AdminService;

/**
 * Servlet implementation class AddDepartment
 */
@WebServlet("/admin/AddDepartment")
public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDepartment() {
        super();
        // TODO Auto-generated constructor stub
        service= new AdminService();
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		if(session.getAttribute("user")==null || session.getAttribute("role")!="admin") { 
			response.sendRedirect("../Register.jsp");
			}
		
		// TODO Auto-generated method stub
			try(PrintWriter printWriter=response.getWriter()){
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				String head=request.getParameter("head");
				String departmentName=request.getParameter("department_name");
				Department department=new Department(departmentName, head, email, password, 2);
				service.addDepartment(department);
				RequestDispatcher dispatcher= request.getRequestDispatcher("Welcome.jsp");
				dispatcher.include(request, response);			
			}
		}



}
