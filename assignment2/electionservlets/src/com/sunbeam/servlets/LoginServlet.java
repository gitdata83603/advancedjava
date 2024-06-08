package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		processRequest(req, resp);
	}
	
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		
		try(UserDao userDao = new UserDaoImpl()) 
		{
			User user = userDao.findByEmail(email);
			
			if(user != null && user.getPassword().equals(passwd))
			{
				// login successful
				Cookie c = new Cookie("uname", user.getFirstName());
				c.setMaxAge(3600); // 3600 seconds = 1 hour
				resp.addCookie(c);
				
				HttpSession session = req.getSession();
				session.setAttribute("curuser", user);
				
				//System.out.println("Login Successful: " + user);
				if(user.getRole().equals("voter")) 
				{ // voter login
					resp.sendRedirect("candlist");   //redirection to candlist servlet
					
					//RequestDispatcher rd = req.getRequestDispatcher("candlist");
					//rd.forward(req, resp);
				}
				else 
				{ // admin login
					resp.sendRedirect("result");
				}
			}
			else 
			{
				// login failed
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Invalid email or password. <br/><br/>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
			// due to throws clause, this method can throw only ServletException or IOException. Other types not allowed.
			// in such case we can wrap exception in another unchecked exception or allowed checked exception and throw it.
			// this is called as "exception chaining" or "nested exception".
		}
	}
}






