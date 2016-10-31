package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
	
		DatastoreService ss=DatastoreServiceFactory.getDatastoreService();
		Entity entity=new Entity(request.getParameter("kind"), request.getParameter("key"));
	
	Key k=entity.getKey();
	ss.delete(k);
	PrintWriter pp=resp.getWriter();
	pp.println();
	
		
		
	}
}
