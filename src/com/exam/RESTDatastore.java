package com.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.appengine.api.datastore.*;

import entities.Entity;
import entities.Properties;

@Path("/datastoreservice")

public class RESTDatastore {
	@Path("/createentity")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
    @POST
	public String createEntity(Entity entity) 
	{
		  com.google.appengine.api.datastore.Entity entity1 = 
				  new com.google.appengine.api.datastore.Entity(entity.getKind(),entity.getKey());
		  for(Properties prop:entity.getProperties())
			  entity1.setProperty(prop.getProname(),prop.getProvalue());
		  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		  Key k=datastore.put(entity1);
		  String result = "<b> Your entity has been created with ID="+k.toString()+" </b><br>";
	
	      return result; 

		
		
	}
	  @POST
	  @Consumes("application/x-www-form-urlencoded")
	  @Produces(MediaType.APPLICATION_XML)
	  @Path("/retrieveentity")
	  public Entity retrieveEntity(@FormParam("kind") String kind, @FormParam("key") String key) {
		  Key generateKey=KeyFactory.createKey(kind, key);
		  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		  Entity res=new Entity();
		  com.google.appengine.api.datastore.Entity entity1;
		try {
			entity1 = datastore.get(generateKey);
			res.setKey(key);
			res.setKind(kind);
			List<Properties> propList=new ArrayList<Properties>();
			
			for (Map.Entry<String, Object> entry : entity1.getProperties().entrySet()) {
				Properties prop=new Properties();
			     prop.setProname(entry.getKey());
			     prop.setProvalue(entry.getValue().toString());
			     propList.add(prop);
			}
			
			res.setProperties(propList);
			return res;
			  
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	  }
	  
	  @POST
	  @Consumes("application/x-www-form-urlencoded")
	  @Produces(MediaType.APPLICATION_XML)
	  @Path("/deleteentity")
	  public String deleteEntity(@FormParam("kind") String kind, @FormParam("key") String key) {
		  //It is required to be implemented by you.
		  Key generateKey=KeyFactory.createKey(kind, key);
		  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		  datastore.delete(generateKey);
		  return "hhj";
	  }
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  @Path("yaRab")
	  public String sayPlainTextHello() {
	    return "Yarab";
	  }

}
