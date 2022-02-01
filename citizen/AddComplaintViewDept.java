package com.cybage.controller.citizen;

import java.io.IOException;
import java.util.ArrayList;

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
import com.cybage.service.CitizenService;

/**
 * Servlet implementation class AddDepartment
 */
@WebServlet("/citizen/NewComplaint")
public class AddComplaintViewDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CitizenService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComplaintViewDept() {
        super();
        // TODO Auto-generated constructor stub
        service= new CitizenService();
        
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
		if(session.getAttribute("user")==null || session.getAttribute("role")!="citizen") { 
			response.sendRedirect("../Register.jsp");
			}
			ArrayList<Department> departments=(ArrayList<Department>) service.departmentList();
			departments.forEach(i->System.out.println(i));
			session.setAttribute("deptList",departments);
			RequestDispatcher dispatcher= request.getRequestDispatcher("NewComplaint.jsp");
			dispatcher.include(request, response);

	}

}
