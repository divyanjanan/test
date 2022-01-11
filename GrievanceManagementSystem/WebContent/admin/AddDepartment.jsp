<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if(session.getAttribute("user")==null || session.getAttribute("role")!="admin") { 
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
                    <li>
                        <a class="nav-link" href="ViewDepartment">
                            <i class="nc-icon nc-paper-2"></i>
                            <p>Departments</p>
                        </a>
                    </li>
                    <li class="nav-item active">
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
                    <a class="navbar-brand" href="#pablo"> New Department Registration </a>
                    
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
                            <div class="info">
					            <div class="container" style="margin-top: 50px">
					                <div id="login-row" class="row justify-content-center align-items-center">
					                  <div id="login-column" class="col-md-6">
					                    <div id="login-box" class="col-md-12">
					                      <form id="login-form" class="form" action="AddDepartment" method="post">
					                        <h3 class="text-center text-info">Add Department</h3><br>
					                        <div class="form-group">
					                          <label for="username" class="text-info">Department Head:</label><br />
					                          <input
					                            type="text"
					                            name="head"
					                          
					                            class="form-control"
					                            required
					                          />
					                        </div>
					                        <div class="form-group">
					                          <label for="username" class="text-info">Email:</label><br />
					                          <input
					                            type="email"
					                            name="email"
					                          
					                            class="form-control"
					                            required
					                          />
					                        </div>
					                        <div class="form-group">
					                          <label for="password" class="text-info">Password:</label><br />
					                          <input
					                            type="password"
					                            name="password"
					                         
					                            class="form-control"
					                            required
					                          />
					                        </div>
					                        
					                        <div class="form-group">
					                          <label for="department_name" class="text-info">Department Name:</label><br />
					                          <input
					                            type="text"
					                            name="department_name"
					                          
					                            class="form-control"
					                            required
					                          />
					                        </div></br>
					                        <div class="form-group" style="text-align: center">
					                          <button
					                            id="loginbtn"
					                            type="submit"
					                            name="submit"
					                            class="btn btn-info align-content-center"
					                          >
					                            Add Department</button
					                          ><br /><br />
					                        </div>
					                      </form>
					                    </div>
					                  </div>
					                </div>
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