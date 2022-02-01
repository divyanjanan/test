package com.cybage.controller.citizen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.model.Citizens;
import com.cybage.service.CitizenService;

/**
 * Servlet implementation class removeDepartment
 */
@WebServlet("/citizen/SendReminder")
public class SendReminder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CitizenService service;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init(ServletConfig config) throws ServletException {
		service=new CitizenService();
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(session.getAttribute("user")==null || session.getAttribute("role")!="citizen") { 
			response.sendRedirect("../Register.jsp");
			}
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
		Citizens citizen = (Citizens) session.getAttribute("user");
		if(session.getAttribute("user")==null || session.getAttribute("role")!="citizen") { 
			response.sendRedirect("../Register.jsp");
			}
			
		    String complaint_id=request.getParameter("complaint_id").toString();
		    System.out.println(complaint_id);
			String msg = service.sendReminder(complaint_id, citizen.getCitizenId());
			//response.sendRedirect("viewDepartment");
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('"+msg+"');");
			   out.println("location='viewDepartment';");
			   out.println("</script>");

}
}