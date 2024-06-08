package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;


@WebServlet("/result")
public class ReasultServlet extends HttpServlet 
{
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
	// TODO Auto-generated method stub
    process(req, resp);	   
   }
   
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
		// TODO Auto-generated method stub	
	   process(req, resp);
	}
   
   
   void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {		
			List<Candidate> list = new ArrayList<Candidate>();
			
			try(CandidateDao candDao = new CandidateDaoImpl()) 
			{
				list = candDao.findAll();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
				throw new ServletException(e);
			}
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Candidates list</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>CANDIDATES</h3>");
			
			String userName = "";
			Cookie[] arr = req.getCookies();
			if(arr != null) 
			{
				for (Cookie c : arr)
				{
					if(c.getName().equals("uname")) 
					{
						userName = c.getValue();
						break;
					}
				}
			}
			out.printf("Hello, %s<hr/>\n", userName);
			
			//out.println("<form method='post' action='vote'>");   //vote servlet will be called
			out.println("<table>");
			out.println("<tr>");	
			out.println("<td>id</td>");  
			out.println("<td>name</td>");   
			out.println("<td>party</td>");  
			out.println(" <td>votes</td>");             
		    out.println("</tr>");       
		        
		   
			
			for (Candidate c : list) 
			{
				// <input type='radio' name='candidate' value='submit-value'/> display-label
//				out.printf("<input type='radio' name='candidate' value='%d'/> %s (%s) <br/>\n", 
//						c.getId(), c.getName(), c.getParty());
				out.println("<tr>");
				out.printf("<td>%d</td>",c.getId());
				out.printf("<td>%s</td>",c.getName());
				out.printf("<td>%s</td>",c.getParty());
				out.printf("<td>%d</td>",c.getVotes());
				out.println("</tr>");
			}
			out.println(" </table>");
			out.println("</body>");
			out.println("</html>");
   }
   
}
