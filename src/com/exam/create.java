package com.exam;


import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;




import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import entities.Entity;
import entities.Properties;



@SuppressWarnings("serial")
public class create extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException 
	{
		
	String kind=request.getParameter("kind");
		String key=request.getParameter("key");

		int count=Integer.parseInt(request.getParameter("count"));
		Entity entity=new Entity();
		entity.setKey(key);
		entity.setKind(kind);
		List<Properties>lis=new ArrayList<Properties>();
		for(int i=0;i<count;i++)
				
	{
			Properties p=new Properties();
			p.setProname(request.getParameter("pro"+i));
			p.setProvalue(request.getParameter("val"+i));
			lis.add(p);
			
	
	}
	entity.setProperties(lis);
	String baseURI=request.getRequestURL().toString();
	baseURI=baseURI.substring(0, baseURI.lastIndexOf('/')+1);

 ClientConfig config = new DefaultClientConfig();
Client client = Client.create(config);
WebResource service = client.resource(getBaseURI(baseURI));
	        	   
	ClientResponse cr=service.path("createentity").type(MediaType.APPLICATION_XML).
			accept(MediaType.APPLICATION_XML).post(ClientResponse.class,entity);
	
	        		  
	request.setAttribute("result", "created Entity with key="+cr.getEntity(String.class));
	request.getRequestDispatcher("/").forward(request, resp);   		  	
	
	    

	}
	private URI getBaseURI(String baseURI) {
		String apiLocation=baseURI+"rest/datastoreservice/";
		return UriBuilder.fromUri(apiLocation).build();
	}

	

}
