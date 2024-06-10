package jspapp;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegisterBean 
{
	String firstname;//=req.getParameter("firstname");
	
	String lastname;//=req.getParameter("lastname");
	
	String email;//=req.getParameter("email");
	
	String password;//=req.getParameter("password");
	
	String dob;//=req.getParameter("dob");
	//Date birth = Date.valueOf(dob);
	
	String role="voter";
	int status=0;
	int createdstatus;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getcreatedstatus() {
		return createdstatus;
	}
	public void setcreatedstatus(int status) {
		this.createdstatus = status;
	}
	public RegisterBean() {
		super();
	}
	public RegisterBean(String firstname, String lastname, String email, String password, String dob, String role,
			int status) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.role = role;
		this.status = status;
	}
	
	public void register()
	{
		Date birth = Date.valueOf(this.dob);
		User user=new User(0, this.firstname, this.lastname, this.email, this.password,birth, this.status,
				this.role);
		
		try {
			UserDao userd=new UserDaoImpl();
			 int cnt= userd.save(user);
			 if(cnt!=0)
			 {
				 createdstatus=1; 
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
