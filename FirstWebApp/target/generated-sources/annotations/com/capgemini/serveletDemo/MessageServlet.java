package com.capgemini.serveletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageServlet extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException 
	{
		String nm= req.getParameter("name");
		
		
		PrintWriter out = res.getWriter();
        out.println("Hello \n Welcome "+nm+"!");
	}
}
