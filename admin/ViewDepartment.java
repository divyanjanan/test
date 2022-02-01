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

import com.cybage.model.Department;
import com.cybage.service.AdminService;

/**
 * Servlet implementation class ViewDepartment
 */
@WebServlet("/admin/ViewDepartment")
public class ViewDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
     AdminService service;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewDepartment() {
        super();
        // TODO Auto-generated constructor stub
        service= new AdminService();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		if(session.getAttribute("user")==null || session.getAttribute("role")!="admin") { 
			response.sendRedirect("../Register.jsp");
			}
		// TODO Auto-generated method stub
		ArrayList<Department> departments=(ArrayList<Department>) service.departmentList();
		departments.forEach(i->System.out.println(i));
		session.setAttribute("departmentList",departments);
		RequestDispatcher dispatcher= request.getRequestDispatcher("viewDepartment.jsp");
		dispatcher.include(request, response);
	}
	


	

}
