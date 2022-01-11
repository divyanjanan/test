<%@page import="java.util.List"%>
<%@page import="com.cybage.model.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<% if(session.getAttribute("user")==null || session.getAttribute("role")!="citizen") { 
	response.sendRedirect("../Register.jsp");
	}
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Admin - New Dept. Registration</title>
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
        <div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
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
                    
                    <li class="nav-item active">
                        <a class="nav-link" href="ViewCitizenComplaint">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>My Complaints</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="NewComplaint.jsp">
                            <i class="nc-icon nc-notes"></i>
                            <p>Register Complaint</p>
                        </a>
                    </li>

                    <li>
                        <a class="nav-link" href="../LogoutServlet">
                            <i class="nc-icon nc-atom"></i>
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
                    <a class="navbar-brand" href="#pablo">Complaint Registration </a>
                    
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                            
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="#pablo">
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
                                    <h4 class="card-title">My Complaints Report</h4>
                                </div>
                                <div class="card-body table-full-width table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                            <th>ID</th>
                                            <th>Details</th>
                                            <th>Department</th>
                                            <th>Date</th>
                                            <th>Status</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${sessionScope.myComplaintList}" var="complaint">
									        	<tr>
									        		<td><c:out value="${complaint.getCpId() }"></c:out></td>
									        		<td><c:out value="${complaint.getCpDetails() }"></c:out></td>
									        		<td><c:out value="${complaint.getDeptId() }"></c:out></td>
									        		<td><c:out value="${complaint.getRegDate() }"></c:out></td>
									        		<td><c:out value="${complaint.getStatus() }"></c:out></td>
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
                            ©
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