<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script> 
function validate()
{ 
	//FullName,Email,Mobile,Aadhar,Address,Gender,Password;
     var FullName = document.form.FullName.value;
     var Email = document.form.Email.value;
     var Mobile = document.form.Mobile.value; 
     var Aadhar = document.form.Aadhar.value;
     var Address = document.form.Mobile.value; 
     var Gender = document.form.Aadhar.value;
     var Password= document.form.Password.value;
     
     if (FullName==null || FullName=="")
     { 
     alert("Full Name can't be blank"); 
     return false; 
     }
     else if (Email==null || Email=="")
     { 
     alert("Email can't be blank"); 
     return false; 
     }
     else if (Mobile==null || Mobile=="")
     { 
     alert("Mobile can't be blank"); 
     return false; 
     }
     else if (Aadhar==null || Aadhar=="")
     { 
     alert("Aadhar can't be blank"); 
     return false; 
     }
     else if (Address==null || Address=="")
     { 
     alert("Address can't be blank"); 
     return false; 
     }
     else if (Gender==null || Gender=="")
     { 
     alert("Gender can't be blank"); 
     return false; 
     }
     else if(Password.length<6)
     { 
     alert("Password must be at least 6 characters long."); 
     return false; 
     } 
     
     } 
     

</script> 
</head>
<body>
<center><h2>Citizen Registration Form </h2></center>
    <form name="form" action="CitizensRegistration" method="post" onsubmit="return validate()">
        <table align="center">
      
         <tr>
         <td>Full Name</td>
         <td><input type="text" name="name" /></td>
         </tr>
         <tr>
         <td>Email</td>
         <td><input type="text" name="email" /></td>
         </tr>
         <tr>
         <td>Password</td>
         <td><input type="password" name="password" /></td>
         </tr>
         <tr>
         <td>Mobile</td>
         <td><input type="text" name="mobile" /></td>
         </tr>
         <tr>
         <td>Aadhar</td>
         <td><input type="text" name="aadhaar" /></td>
         </tr>
         <tr>
         <td>Address</td>
         <td><input type="text" name="address" /></td>
         </tr>
         <tr>
         <td>Gender</td>
         <td><input type="gender" name="gender" /></td>
         </tr>
         <tr>
         <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
         <tr>
         <td></td>
         <td><input type="submit" value="Register"></input><input
         type="reset" value="Reset"></input></td>
         </tr>
        </table>
    </form>
</body>
</html>