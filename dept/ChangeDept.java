package com.cybage.controller.dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.service.DeptService;

/**
 * Servlet implementation class AddDepartment
 */
@WebServlet("/dept/ChangeDept")
public class ChangeDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeptService service;
       
    /**
     * @throws SQLException 
     * @throws ClassNotFoundException 
     * @see HttpServlet#HttpServlet()
     */
    public ChangeDept() throws ClassNotFoundException, SQLException {
        super();
        // TODO Auto-generated constructor stub
        service= new DeptService();
        
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
		if(session.getAttribute("user")==null || session.getAttribute("role")!="dept") { 
			response.sendRedirect("../Register.jsp");
			}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		if(session.getAttribute("user")==null || session.getAttribute("role")!="dept") { 
			response.sendRedirect("../Register.jsp");
			}else {
		
		// TODO Auto-generated method stub
			try(PrintWriter printWriter=response.getWriter()){
				String id=request.getParameter("complaint_id");
				String dept=request.getParameter("department");
				String msg = service.changeDept(id, dept);

				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('"+msg+"');");
				   out.println("location='ViewComplaint';");
				   out.println("</script>");
			}
		}

	}

}
