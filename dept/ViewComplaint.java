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
@WebServlet("/dept/ViewComplaint")
public class ViewComplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DeptService service;  
	    /**
	     * @throws SQLException 
	     * @throws ClassNotFoundException 
	     * @see HttpServlet#HttpServlet()
	     */
	    public ViewComplaint() throws ClassNotFoundException, SQLException {
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
			ArrayList<Complaint> complaints=(ArrayList<Complaint>) service.complaintList(user.getDeptId());
			complaints.forEach(i->System.out.println(i));
			session.setAttribute("deptComplaint",complaints);
			RequestDispatcher dispatcher= request.getRequestDispatcher("viewComplaint.jsp");
			dispatcher.include(request, response);
		}

}
}


