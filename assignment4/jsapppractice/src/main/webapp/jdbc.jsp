<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <%
         String email=request.getParameter("email");
       String password=request.getParameter("password");
       
       
   	String DB_URL = "jdbc:mysql://localhost:3306/election";
   			String DB_USER = "root";
   			String DB_PASS = "manager";
   			Class.forName("com.mysql.cj.jdbc.Driver");
   			
   			try(Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) 
   			{
   				String sql = "SELECT * FROM users WHERE email=? AND password=?";
   				try(PreparedStatement stmt = con.prepareStatement(sql)) {
   					stmt.setString(1, email);
   					stmt.setString(2, password);
   					try(ResultSet rs = stmt.executeQuery()) 
   					{
   						if(rs.next())
   						{
   							String name = rs.getString("first_name");
   							out.println("Welcome, " + name);
   						}
   						else
   							out.println("Invalid Login");
   					} 
   				} 
   			}
   			catch(Exception e) 
   			{
   				out.println("Error: " + e.getMessage());
   			}
       
       %>
</body>
</html>