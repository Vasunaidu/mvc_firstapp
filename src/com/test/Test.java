package com.test;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Test() {
		super();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String first_Name=req.getParameter("First_Name");
		String last_Name=req.getParameter("Last_Name");
		String birth_day=req.getParameter("Birthday_day");
		String birth_month=req.getParameter("Birthday_Month");
		String birth_year=req.getParameter("Birthday_Year");
		String email_id=req.getParameter("Email_Id");
		String mobile_number=req.getParameter("Mobile_Number");
		String gender=req.getParameter("Gender");
		String address=req.getParameter("Address");
		String city=req.getParameter("City");
		String pin_Code=req.getParameter("Pin_Code");
		String state=req.getParameter("State");
		String country=req.getParameter("Country");
		String hobby_Drawing=req.getParameter("Hobby_Drawing");
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			int i=stmt.executeUpdate("insert into My_Emp values("
					+ "'"+first_Name+"', '"+last_Name+"', '"+birth_day+"','"+birth_month+"'"
							+ ",'"+birth_year+"','"+email_id+"','"+mobile_number+"','"+gender+"','"+address+"','"+city+"','"+pin_Code+"','"+state+"','"+country+"','"+hobby_Drawing+"')");
			if(i>0)          {      
				pw.println("Registered successful"); 
			RequestDispatcher dis=req.getRequestDispatcher("login.html");          
	          dis.include(req, res);  
			}
			else
			{
				pw.println("Registered Unsuccessful Please try again"); 
				RequestDispatcher dis=req.getRequestDispatcher("index.html");          
				dis.include(req, res);  
        }
		}
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
