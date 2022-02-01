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

import com.cybage.model.Complaint;
import com.cybage.service.AdminService;

/**
 * Servlet implementation class ViewComplaint
 */
@WebServlet("/admin/ViewComplaint")
public class ViewComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 AdminService service;  
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ViewComplaint() {
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
			ArrayList<Complaint> complaints=(ArrayList<Complaint>) service.complaintList();
			complaints.forEach(i->System.out.println(i));
			session.setAttribute("complaintList",complaints);
			RequestDispatcher dispatcher= request.getRequestDispatcher("viewComplaint.jsp");
			dispatcher.include(request, response);
		}

}


