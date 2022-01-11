<%@page import="java.util.List"%>
<%@page import="com.cybage.model.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<% if(session.getAttribute("user")==null || session.getAttribute("role")!="admin") { 
	response.sendRedirect("../Register.jsp");
	}
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Admin - Departments</title>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no" name="viewport">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
 
   
    <!-- Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
    <!-- CSS Files -->
    <link href="https://demos.creative-tim.com/light-bootstrap-dashboard/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://demos.creative-tim.com/light-bootstrap-dashboard/assets/css/light-bootstrap-dashboard.css?v=2.0.1" rel="stylesheet">
    <style>
    .card .table tbody td:last-child, .card .table thead th:last-child {
    padding-right: 15px;
    display: flex;
	}
    </style>
    
 	
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
                    <li>
                        <a class="nav-link" href="dashboard.html">
                            <i class="nc-icon nc-chart-pie-35"></i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="ViewCitizens">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Citizens</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="ViewComplaint">
                            <i class="nc-icon nc-notes"></i>
                            <p>Complaints</p>
                        </a>
                    </li>
                    <li  class="nav-item active">
                        <a class="nav-link" href="ViewDepartment">
                            <i class="nc-icon nc-paper-2"></i>
                            <p>Departments</p>
                        </a>
                    </li>
                    <li>
                        <a class="nav-link" href="AddDepartment.jsp">
                            <i class="nc-icon nc-atom"></i>
                            <p>Dept. Registration</p>
                        </a>
                    </li>
                    

                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class=" container-fluid  ">
                    <a class="navbar-brand" href="#pablo"> Departments </a>
                    
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
                        <div class="col-md-6">
                            <div class="card strpied-tabled-with-hover">
                                <div class="card-header ">
                                    <h4 class="card-title">PCMC Departments</h4>
                                </div>
                                
                                <div class="card-body table-full-width table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Dept. Head</th>
                                            <th>Email</th>
                                        </thead>
                                        <tbody>
                                             <c:forEach items="${sessionScope.departmentList}" var="department">
									        	<tr>
									        		<td><c:out value="${department.getDeptId() }"></c:out></td>
									        		<td><c:out value="${department.getDeptName() }"></c:out></td>
									        		<td><c:out value="${department.getDeptHead() }"></c:out></td>
									        		<td><c:out value="${department.getDeptEmail() }"></c:out></td>
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