package com.exam;
import java.util.Map;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
public class Tr {
	public static String MAILGUN_API_KEY = "key-a99855523e4a5e0ce492ea83a63a12f0";
    public 	static String MAILGUN_DOMAIN_NAME = "sandboxf236cf4e4cb442d68b9ae2c8a6d2caca.mailgun.org";
	public Tr() {
		// TODO Auto-generated constructor stub
	}
	public   static ClientResponse sendSimpleMessage(String recipient,String tex,String subb) {
	
		  Client client = Client.create();
		    client.addFilter(new HTTPBasicAuthFilter("api", MAILGUN_API_KEY));
		    WebResource webResource = client.resource("https://api.mailgun.net/v3/" + MAILGUN_DOMAIN_NAME
		        + "/messages");
		    MultivaluedMapImpl formData = new MultivaluedMapImpl();
		
		    formData.add("from", "Mailgun User <hussienalbared@" + MAILGUN_DOMAIN_NAME + ">");
		    formData.add("to", recipient);
		    formData.add("subject", subb);
		    formData.add("text",tex);
		    
		    
		    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
		               post(ClientResponse.class, formData);
		  }
	 
}
