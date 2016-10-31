package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.*;
@SuppressWarnings("serial")
public class create extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
	
		DatastoreService ss=DatastoreServiceFactory.getDatastoreService();
		Entity entity=new Entity(request.getParameter("kind"), request.getParameter("key"));
	entity.setProperty(request.getParameter("name"), request.getParameter("value"));
	ss.put(entity);

	
	
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse resp)
	{
		
		
		
		
	}

}
