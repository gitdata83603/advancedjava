<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <form method="POST" action="LoginBean.jsp" >
       Email : <input type="email" name="email"/>
       <br>
       <br>
       Passw : <input type="password" name="password"/>
       <br>
       <br>
       <input type='submit' value="Sign In"/>
       <a href="newuser.jsp">Sign Up</a>
   </form>
     
</body>
</html>