package com.cybage.controller.dept;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.model.Complaint;
import com.cybage.model.Department;
import com.cybage.service.DeptService;

/**
 * Servlet implementation class ViewComplaint
 */
@WebServlet("/dept/ComplaintActions")
public class ComplaintActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DeptService service;  
	    /**
	     * @throws SQLException 
	     * @throws ClassNotFoundException 
	     * @see HttpServlet#HttpServlet()
	     */
	    public ComplaintActions() throws ClassNotFoundException, SQLException {
	        super();
	        // TODO Auto-generated constructor stub
	        service= new DeptService();
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			HttpSession session= request.getSession();
			if(session.getAttribute("user")==null || session.getAttribute("role")!="dept") { 
				response.sendRedirect("../Register.jsp");
				}else {
			Department user = (Department) session.getAttribute("user");
			// TODO Auto-generated method stub
			ArrayList<Complaint> complaints1=(ArrayList<Complaint>) service.complaintFiledList(user.getDeptId());
			ArrayList<Complaint> complaints2=(ArrayList<Complaint>) service.complaintProcessList(user.getDeptId());
			session.setAttribute("complaintAction1",complaints1);
			session.setAttribute("complaintAction2",complaints2);
			RequestDispatcher dispatcher= request.getRequestDispatcher("complaintActions.jsp");
			dispatcher.include(request, response);
		}
		}

}


