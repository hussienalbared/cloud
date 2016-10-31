package com.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.google.appengine.api.datastore.*;

@SuppressWarnings("serial")
public class RetrieveServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pp=resp.getWriter();
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
	
	}

}
