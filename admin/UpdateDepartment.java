package com.cybage.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/admin/UpdateDept")
public class UpdateDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDepartment() {
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
		
		// TODO Auto-generated method stub
			try(PrintWriter printWriter=response.getWriter()){
				String id=request.getParameter("id");
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				String head=request.getParameter("head");
				String departmentName=request.getParameter("department_name");
				Department department=new Department(id, departmentName, email, head, password);
				String msg = service.updateDepartment(department);
	
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('"+msg+"');");
				   out.println("location='ViewDepartment';");
				   out.println("</script>");
			}
		}

	}

}
