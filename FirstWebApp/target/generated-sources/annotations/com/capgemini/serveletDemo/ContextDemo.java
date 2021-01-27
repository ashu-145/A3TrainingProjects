package com.capgemini.serveletDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextDemo extends HttpServlet {
	protected void service(HttpServletRequest req , HttpServletResponse res) throws IOException
    {
        PrintWriter out = res.getWriter();
        out.println("Hi<br/>");
        
        //Tomcat gives the object of servletcontext 
       ServletContext ctx = getServletContext();
       // ServletConfig config = getServletConfig();
     //ctx.getInitParameter("name");
     //   config.getInitParameter("Phone");
        
        String str= ctx.getInitParameter("Phone");
        //String str= config.getInitParameter("Phone");
        
        out.println(str);

        
    }


}
