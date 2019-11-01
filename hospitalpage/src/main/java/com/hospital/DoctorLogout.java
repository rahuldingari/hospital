package com.hospital;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/doclogout")
public class DoctorLogout  extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		HttpSession session =req.getSession();
		session.removeAttribute("username");
		session.invalidate();
		res.sendRedirect("doctorlogin.jsp");
		
	}

}
