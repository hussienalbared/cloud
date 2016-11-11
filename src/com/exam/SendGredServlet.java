package com.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.labs.repackaged.org.json.JSONException;

public class SendGredServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	String text=req.getParameter("tex");
	String subject=req.getParameter("subjec");
	String to=req.getParameter("t");
	Sendgrid s=new Sendgrid();
	s.setFrom("hussienalbared@gmail.com");
	s.setText(text);
	s.setSubject(subject);
	s.setTo(to);
	try {
		s.send();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
