package com.cybage.controller.admin;

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

import com.cybage.model.Department;
import com.cybage.service.AdminService;

/**
 * Servlet implementation class ViewDepartment
 */
@WebServlet("/admin/UpdateDepartment")
public class UpdateDeptDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
     AdminService service;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDeptDetails() {
        super();
        // TODO Auto-generated constructor stub
        service= new AdminService();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(session.getAttribute("user")==null || session.getAttribute("role")!="admin") { 
			response.sendRedirect("../Register.jsp");
			}
	}
    
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		if(session.getAttribute("user")==null || session.getAttribute("role")!="admin") { 
			response.sendRedirect("../Register.jsp");
			}
		// TODO Auto-generated method stub
		
		try(PrintWriter printWriter=response.getWriter()){
			String department=request.getParameter("department_name");
			Department departments=(Department) service.updateDeptList(department);
			session.setAttribute("updateDept",departments);
			RequestDispatcher dispatcher= request.getRequestDispatcher("UpdateDepartment.jsp");
			dispatcher.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
