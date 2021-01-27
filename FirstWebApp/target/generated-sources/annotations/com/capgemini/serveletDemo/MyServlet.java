package com.capgemini.serveletDemo;

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
@WebServlet("/add")
public class MyServlet extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException 
	{
		int a= Integer.parseInt(req.getParameter("num1"));
		int b= Integer.parseInt(req.getParameter("num2"));
		HttpSession session =req.getSession();
		
		int x=a+b;
//		session.setAttribute("Sum", c);
//		session.setAttribute("x", 12);
		 Cookie cookie = new Cookie("x" ,x+""); //string has to be passed so we are concatenating
         res.addCookie(cookie);
		
//		System.out.println(x);
//		
		PrintWriter out = res.getWriter();
        out.println("the result is " +x);
        
//        RequestDispatcher rd = req.getRequestDispatcher("Square");
//       rd.forward(req, res);
       //rd.include(req, res);
       // res.sendRedirect("Square?c="+c);
        res.sendRedirect("Square");
        
        //res.sendRedirect("http://localhost:8081/FirstWebApp/Message.html");
	}
}
