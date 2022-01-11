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
        <div class="info">
            <div class="container" style="margin-top: 50px">
                <div id="login-row" class="row justify-content-center align-items-center">
                  <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                      <form id="login-form" class="form" action="RemoveDepartment" method="post">
                        <h3 class="text-center text-info">Remove Department</h3>
                       <div class="form-group">
                          <label for="password" class="text-info">Department Name:</label><br />
                          <select class="form-select" name="department_name" aria-label="Default select example">
                              <option selected>Open this select menu</option>
                              <option value="BIRTH_REGISTRATION">Birth Registration Department</option>
                              <option value="DEATHS_REGISTRAION">Death Registration Department</option>
                              <option value="DRAINAGE">Drainage Department</option>
                              <option value="ELECTRICITY">Electricity Department</option>
                              <option value="HEALTH">Health Department</option>
                              <option value="WATER">Water Department</option>
                              <option value="PROPERTY_TAX">Property Tax Department</option>
                              <option value="ROAD">Road Department</option>
                            </select>
                        </div></br>
                        <div class="form-group" style="text-align: center">
                          <button
                            id="loginbtn"
                            type="submit"
                            name="submit"
                            class="btn btn-info align-content-center"
                          >
                            Remove Department</button
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
	

</body>
	
</html>