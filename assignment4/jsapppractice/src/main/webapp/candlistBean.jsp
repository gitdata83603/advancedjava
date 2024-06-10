<%@page import="java.util.ArrayList"%>
<%@page import="com.sunbeam.pojos.Candidate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
</head>
<body>
   <h1>Candidates</h1> 
   <jsp:useBean id="lb" class="jspapp.CandidateListBean"/>
   <%
     List<Candidate> cd=new ArrayList<Candidate>();
        cd= lb.candlist();
       // out.println(cd);
        //out.println("hi avdhut");
       if(cd==null)
       {
    	out.println("error in loading candidate list");   
       }
       else
       {
    	   out.println("<form method='post' action='vote'>");
    	   for(Candidate c:cd)
    	   {
    		//   <input type='radio' name='candidate' value='%d'/> %s (%s) <br/>\n", 
   				//	c.getId(), c.getName(), c.getParty()
    		   
   			  out.println("<input type='radio' name='candidate' value="+c.getId()+"/>"+c.getName()+"("+c.getParty()+")" +"<br/>\n");	
    		  //out.println("name : "+c.getName()+"  party : "+c.getParty()+"  votes : "+c.getVotes());
    	   }
    	   out.println("<input type='submit' value='Vote'/>");
   		out.println("</form>");
       }
   
   %>
   
</body>
</html>