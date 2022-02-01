package com.cybage.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/admin/RemoveDepartment")
public class RemoveDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminService service;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init(ServletConfig config) throws ServletException {
		service=new AdminService();
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
			}else {
			
		    String departmentName=request.getParameter("department_name").toString();
		    System.out.println(departmentName);
			String msg=service.removeDepartment(departmentName);
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('"+msg+"');");
			   out.println("location='ViewDepartment';");
			   out.println("</script>");
			   
			//response.sendRedirect("ViewDepartment");

			}
}
}