<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
    <div style="margin-left: 50; text-align: center; background-color: rgb(164, 100, 237);">
      <h1>SIGN UP</h1>
    
     <form method="POST" action="registerBean.jsp" style="margin-left: 50;">
     firstname :   <input type="text" name="firstname" >
     <br><br>
     lastname  :   <input type="text" name="lastname" >
     <br><br>
     
     email     :   <input type="email" name="email">
     <br><br>

     password  :   <input type="password" name="password">
     <br><br>

      DOB      :    <input type='date' name="dob">
      
    <br>
     <br>
     <input type="submit" value="Create User" style="background-color: darkgreen;">
 </form>
</body>
</html>