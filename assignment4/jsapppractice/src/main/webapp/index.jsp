<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <h1>Hi avdhut </h1>
       
       <% 
          Date now=new Date();
          out.println("date is : "+now);
       %>
       
       <%!
          int count=0;         
       %>
       
       <%
       
       count++;
       if(count%2==0)
       {
    	   out.println("Even Count : "+count); 
       }
       else
       {
    	   out.println("odd count : "+count);
       }
       %>
       
       
      
       
</body>
</html>