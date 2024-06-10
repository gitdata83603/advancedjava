<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Bean</title>
</head>
<body>
  <jsp:useBean id="ld" class="jspapp.RegisterBean"/>
	<jsp:setProperty name="ld" property="firstname" param="firstname"/>
	<jsp:setProperty name="ld" property="lastname" param="lastname"/>
	<jsp:setProperty name="ld" property="email" param="email"/>
	<jsp:setProperty name="ld" property="password" param="password"/>
	<jsp:setProperty name="ld" property="dob" param="dob"/>
	<% ld.register(); %>
	<% if(ld.getcreatedstatus() == 1) { %>
		  <h1>USER REGISTERED SUCCESSFULLY</h1>
		  <a href="Login.jsp">Go to Login Page</a>
	<% } else { %>
		Login Failed.
	<% } %>
</body>
</html>


