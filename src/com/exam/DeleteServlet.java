package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@SuppressWarnings("serial")
public class DeleteServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
	
		/*DatastoreService ss=DatastoreServiceFactory.getDatastoreService();
		Entity entity=new Entity(request.getParameter("kind"), request.getParameter("key"));
	
	Key k=entity.getKey();
	ss.delete(k);*/
		

		
		
		String key=request.getParameter("key");
		String kind=request.getParameter("kind");
		String baseURI=request.getRequestURL().toString();
		baseURI=baseURI.substring(0, baseURI.lastIndexOf('/')+1);

	 ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);
	WebResource service = client.resource(getBaseURI(baseURI));

	MultivaluedMap queryParams = new MultivaluedMapImpl();
	queryParams.add("kind", kind);
	queryParams.add("key", key);
	String response = service.queryParams(queryParams).post(String.class);

				
		}
		
		private URI getBaseURI(String baseURI) {
			String apiLocation=baseURI+"rest/datastoreservice/deleteentity";
			return UriBuilder.fromUri(apiLocation).build();
		}
}
