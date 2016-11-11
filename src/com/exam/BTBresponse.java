package com.exam;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

public class BTBresponse implements Serializable{
public String kind;
public String key;
public HashMap<String, String> pros;
public BTBresponse() {
	kind=new String();
	
	 
	 
	key=new String();
	pros=new HashMap<String, String>();
	
}
}
