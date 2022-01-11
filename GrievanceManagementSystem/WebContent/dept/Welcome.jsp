<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="welcome.css" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
</head>
<body>
	<h2 style="text-align: center">Grievance Management System</h2>

    <div class="wrapper">
      <div class="sidebar">
        <ul>
          <li>
            <a href="AddDepartment.jsp" class="btn btn-light">Add Department</a>
           
          </li>
          <li>
            <a href="RemoveDepartment.jsp" class="btn btn-light">Remove Department</a>
          </li>
          <li>
            <a href="ViewDepartment" class="btn btn-light">View Department</a>
          </li>
          <li>
            <a href="ViewComplaint" class="btn btn-light">View Complains</a>
          </li>
          <li>
            <a href="ViewCitizens" class="btn btn-light">View Users</a>
          </li>
        </ul>
      </div>
      <div class="main_content">
        <div class="header" style="text-align: center">We welcomes you!</div>
        <div class="info"></div>
      </div>
    </div>
</body>
</html>