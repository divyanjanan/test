package com.cybage.controller.citizen;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.model.Citizens;
import com.cybage.model.Complaint;
import com.cybage.service.CitizenService;

/**
 * Servlet implementation class ViewComplaint
 */
@WebServlet("/citizen/CitizenComplaintReminder")
public class CitizenComplaintReminder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 CitizenService service;  
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public CitizenComplaintReminder() {
	        super();
	        // TODO Auto-generated constructor stub
	        service= new CitizenService();
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session= request.getSession();
			if(session.getAttribute("user")==null || session.getAttribute("role")!="citizen") {
				response.sendRedirect("../Register.jsp");
				}else {
			// TODO Auto-generated method stub
			Citizens citizen = (Citizens) session.getAttribute("user");
			ArrayList<Complaint> complaints=(ArrayList<Complaint>) service.complaintReminderList(citizen.getCitizenId());
			session.setAttribute("myReminderList",complaints);
			RequestDispatcher dispatcher= request.getRequestDispatcher("viewReminder.jsp");
			dispatcher.include(request, response);
		}
		}
}


