package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.Candidate;
import com.sunbeam.pojos.User;

@WebServlet("/newuser")
public class newuserservlet extends HttpServlet
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

		
		String firstname=req.getParameter("firstname");
		
		String lastname=req.getParameter("lastname");
		
		String email=req.getParameter("email");
		
		String password=req.getParameter("password");
		
		String dob=req.getParameter("dob");
		Date birth = Date.valueOf(dob);
		
		String role="voter";
		int status=0;
		//public User(int id, String firstName, String lastName, String email, String password, Date birth, int status,
		//String role
		User user=new User(0,firstname,lastname,email,password,birth,status,role);
		int cnt=0;
		try(UserDao userDao = new UserDaoImpl()) 
		{
			//userDao.save(user);
			 cnt=userDao.save(user);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new ServletException(e);
		}
		if(cnt!=0)
		{
			resp.setContentType("text/html");
		    PrintWriter out=resp.getWriter();
		    out.println("<html>");
			out.println("<head>");
			out.println("<title>User status</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("USER ADDED SUCCESSFULLY <br/><br/>");
			out.println("<a href='index.html'>Login</a>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
