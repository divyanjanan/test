package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.dao.AdminImpl;
import com.cybage.model.Admin;
import com.cybage.model.Citizens;
import com.cybage.model.Department;
import com.cybage.service.AdminService;


/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/Welcome")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminImpl adminDao;
	AdminService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
 public void init() {
        
	 service= new AdminService();
 }
	 
 public void distroy() {
	 try {
    
     }
     catch (Exception e) {
			// TODO: handle exception
		}
}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter printWriter=response.getWriter()){
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			Admin admin=service.authenticateAdmin(email, password);
			Citizens citizen = service.authenticateCitizen(email, password);
			Department dept = service.authenticateDept(email, password);
			HttpSession session= request.getSession();
			if(admin!=null) {
				session.setAttribute("user", admin);
				session.setAttribute("role", "admin");
				session.setAttribute("name", "Admin");
				response.sendRedirect("admin/Welcome.jsp");
				System.out.println(session.getAttribute("user"));
			}else if(citizen!=null){
				System.out.println("In IFFFF");
				session.setAttribute("user", citizen);
				session.setAttribute("name", citizen.getName());
				session.setAttribute("role", "citizen");
				response.sendRedirect("citizen/Welcome.jsp");
				System.out.println(session.getAttribute("user"));
			}else if(dept!=null){
				System.out.println("In IFFFF");
				session.setAttribute("user", dept);
				session.setAttribute("name", dept.getDeptHead());
				session.setAttribute("role", "dept");
				response.sendRedirect("dept/Welcome.jsp");
				System.out.println(session.getAttribute("user"));
			}else {
				RequestDispatcher dispatcher= request.getRequestDispatcher("Register.jsp");
				dispatcher.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
