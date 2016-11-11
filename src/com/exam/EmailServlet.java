package com.exam;


import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EmailServlet extends HttpServlet{

	/**
	 * 
	 */


	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		
		
	
		
	
		String rec=req.getParameter("t");
		String tex=req.getParameter("tex");
		String subb=req.getParameter("subjec");
	
	    Tr.sendSimpleMessage(rec, tex, subb);

	
	}
	
	
	
	

}
