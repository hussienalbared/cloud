package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import com.google.appengine.api.datastore.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import entities.Entity;



@SuppressWarnings("serial")
public class RetrieveServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*PrintWriter pp=resp.getWriter();
		DatastoreService ss=DatastoreServiceFactory.getDatastoreService();
		//Entity entity=new Entity(req.getParameter("kind"),req.getParameter("key"));
		Key key=new Entity(req.getParameter("kind"),req.getParameter("key")).getKey();

		Entity entity;
		try {
			entity = ss.get(key);
			Map<String, Object> m=entity.getProperties();
			Set<String>set=m.keySet();
			for(String s:set)
			{
				pp.print(s+"  "+m.get(s));
		pp.println();		
			}
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//entity.getProperties();
		pp.println("hi");
	
*/
	
	String key=req.getParameter("key");
	String kind=req.getParameter("kind");
	String baseURI=req.getRequestURL().toString();
	baseURI=baseURI.substring(0, baseURI.lastIndexOf('/')+1);

 ClientConfig config = new DefaultClientConfig();
Client client = Client.create(config);
WebResource service = client.resource(getBaseURI(baseURI));

MultivaluedMap queryParams = new MultivaluedMapImpl();
queryParams.add("kind", kind);
queryParams.add("key", key);
Entity response = service.queryParams(queryParams).post(Entity.class);

			resp.getWriter().println(response.getKey());
	}
	
	private URI getBaseURI(String baseURI) {
		String apiLocation=baseURI+"rest/datastoreservice/retrieveentity";
		return UriBuilder.fromUri(apiLocation).build();
	}
}
