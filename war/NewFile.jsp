

<%@page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<form action="firstapp2" method="get">
number 1:<input type="text" name="n1">
<br>
number 2:<input type="text" name="n2">

<br>
<select name="oper">
<option>+</option>
<option>-</option>
<option>/</option>
<option>*</option>

</select>

<br>
<input type="submit" value="Total">


</form>

</body>
</html>