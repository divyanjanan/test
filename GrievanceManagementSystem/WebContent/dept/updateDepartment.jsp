<%@page import="java.util.List"%>
<%@ page import="java.sql.*" %>  
<%@page import="com.cybage.model.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<% if(session.getAttribute("user")==null || session.getAttribute("role")!="dept") { 
	response.sendRedirect("../Register.jsp");
	}
%>
<%
  
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Dept - Change Department</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no" name="viewport">
   
    <!-- Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="https://demos.creative-tim.com/light-bootstrap-dashboard/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://demos.creative-tim.com/light-bootstrap-dashboard/assets/css/light-bootstrap-dashboard.css?v=2.0.1" rel="stylesheet">
   

</head>

<body>
    <div class="wrapper">
        <div class="sidebar" data-image="../assets/img/sidebar-5.jpg" data-color="green">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
            <div class="sidebar-wrapper" >
                <div class="logo">
                    <a href="#" class="simple-text">
                        Java Group 2
                    </a>
                </div>
                <ul class="nav">
                     <li>
                        <a class="nav-link" href="../index.jsp">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>Home</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="ViewComplaint">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Complaints Report</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="ComplaintActions">
                            <i class="nc-icon nc-notes"></i>
                            <p>Complaint Actions</p>
                        </a>
                    </li>
                    
                     <li  class="nav-item active">
                        <a class="nav-link" href="ReassignDept">
                            <i class="nc-icon nc-notes"></i>
                            <p>Update Department</p>
                        </a>
                    </li>
                    
                    <li>
                        <a class="nav-link" href="ViewReminder">
                            <i class="nc-icon nc-bell-55"></i>
                            <p>Complaint Reminders</p>
                        </a>
                    </li>

                    <li>
                        <a class="nav-link" href="../LogoutServlet">
                            <i class="nc-icon nc-button-power"></i>
                            <p>Logout</p>
                        </a>
                    </li>
                    

                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class=" container-fluid  ">
                    <a class="navbar-brand" href="#">${sessionScope.dept_name}</a>
                    
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                            
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span class="no-icon">Hello, ${sessionScope.name}</span>
                                </a>
                            </li>
                           
                            <li class="nav-item">
                                <a class="nav-link" href="../LogoutServlet">
                                    <span class="no-icon">Log out</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card strpied-tabled-with-hover">
                                <div class="card-header ">
                                    <h4 class="card-title">Complaints Report</h4>
                                </div>
                                <div class="card-body table-full-width table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <th>ID</th>
                                            <th>Citizen Name</th>
                                            <th>Details</th>
                                            <th>Registration Date</th>
                                            <th>Department</th>
                                            <th>Action</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${sessionScope.reassignList}" var="complaint">
									        	<tr>
									        		<td><c:out value="${complaint.getCpId() }"></c:out></td>
									        		<td><c:out value="${complaint.getCtName() }"></c:out></td>
									        		<td><c:out value="${complaint.getCpDetails() }"></c:out></td>
									        		<td><c:out value="${complaint.getRegDate() }"></c:out></td>
									        		<td>
									        			<form action="ChangeDept" method="post">
									        			<select class="form-select" aria-label="Default select example" name="department">
									        			<% try{  
									        				Class.forName("com.mysql.jdbc.Driver");  
									        				String url = "jdbc:mysql://localhost:3306/java_project";
									        				Connection con=DriverManager.getConnection(url,"root","Vishal@123"); 
									        				String user_name= (String) session.getAttribute("name");
									        				PreparedStatement ps=con.prepareStatement("select dept_id, dept_name from department where head!='"+user_name+"'"); 
									        				ResultSet rs=ps.executeQuery();									        				
									        				while(rs.next()){ 
									        			%>
									        			<option value=<%=rs.getString(1) %>><%=rs.getString(2) %></option>
									        			<% }}catch(Exception e){out.print(e);} %>
									        		</td>
									        		<td><input type="hidden" name="complaint_id" value="${complaint.getCpId() }" /><button style="margin-right: 10px" class="btn btn-warning btn-sm" type="submit">Assign</button></form></td>
									        	</tr>
									        
									        </c:forEach>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
            <footer class="footer">
                <div class="container">
                    <nav>
                        
                        <p class="copyright text-center">
                            �
                            <script>
                                document.write(new Date().getFullYear())
                            </script>
                            <a href="#">Cybage Java Group 2</a>, Made For Mini Project
                        </p>
                    </nav>
                </div>
            </footer>
        </div>
    </div>


</body>
</html>