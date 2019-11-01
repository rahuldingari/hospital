package com.hospital;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.HospitalDao;
@WebServlet("/DoctorLogin")
public class DoctorLogin extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
	    int h_id=Integer.parseInt(req.getParameter("h_id"));
		HospitalDao d1=new HospitalDao();
		if(d1.doctorValidate(name,pass,h_id))
		{
			HttpSession session=req.getSession();
			session.setAttribute("username",name);
			res.sendRedirect("welcomedoc.jsp");

		}
		else {
			PrintWriter out = res.getWriter();
			out.print("invalid username and password");
			res.sendRedirect("doctorlogin.jsp");
		}
	}

}
