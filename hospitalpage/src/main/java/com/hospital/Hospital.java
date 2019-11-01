package com.hospital;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.HospitalDao;
@WebServlet("/Hospital")
public class Hospital  extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		int h_id=Integer.parseInt(req.getParameter("hospital_id"));
		HospitalDao d3=new HospitalDao();
		if( d3.getHospital(h_id))
		{
			HttpSession session=req.getSession();
			session.setAttribute("hospital_id",h_id);
			res.sendRedirect("new.jsp");

		}
		else {
			PrintWriter out = res.getWriter();
			out.print("invalid username and password");
			res.sendRedirect("index.jsp");
		}
	}

}
