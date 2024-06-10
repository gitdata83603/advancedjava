<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Beans</title>
</head>
<body>                         <%--package.classname  i.e. .java file  --%>
	<jsp:useBean id="lb" class="jspapp.LoginBean"/>
	<jsp:setProperty name="lb" property="email" param="email"/>
	<jsp:setProperty name="lb" property="password" param="password"/>
	<% lb.authenticate(); %>
	<% if(lb.getUser() != null) { %>
		
		<jsp:forward page="candlistBean.jsp"/>
	<% } else { %>
		Login Failed.
	<% } %>
</body>
</html>