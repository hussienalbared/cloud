package com.exam;


import java.io.IOException;

import javax.servlet.http.*;

import org.apache.jasper.tagplugins.jstl.core.Out;

@SuppressWarnings("serial")
public class FirstApp2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		String x=request.getParameter("oper");
		if(request.getParameter("n1").toString().isEmpty()
				||request.getParameter("n2").toString().isEmpty())
		{
			resp.getWriter().println("Error ,please enter two numbers");
		}
		else
		{
		double n1=Double.parseDouble(request.getParameter("n1"));
		double n2=Double.parseDouble(request.getParameter("n2"));
		double total=0.0;
	
		if(x.equals("/"))
		{
			total=n1/n2;
			
		}
		else if(x.equals("*"))
		{
			total=n1*n2;
			
		}
		else if(x.equals("+"))
		{
			total=n1+n2;
			
		}
		else if(x.equals("-"))
		{
			total=n1-n2;
			
		}
		resp.getWriter().println("result of "+n1+ " "+" "+x+" "+n2+" ="+total);

		}
			
}
}