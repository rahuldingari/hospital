package com.hospital;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.HospitalDao;
@WebServlet("/PatientLogin")
public class PatientLogin extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		int h_id=Integer.parseInt(req.getParameter("h_id"));
		HospitalDao d=new HospitalDao();
		if(d.patientValidate(username, password,h_id))
		{
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			res.sendRedirect("welcomepatient.jsp");

		} else {
			PrintWriter out = res.getWriter();
			out.print("invalid username and password");
			res.sendRedirect("patientlogin.jsp");
		}

		}
		
	}


