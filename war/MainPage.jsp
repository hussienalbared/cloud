<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<style type="text/css">
.mainpage
{

background-color: silver;
width:150px;
padding: 50px;
text-decoration: underline;

}


</style>

</head>
<body>
<div class="mainpage">
<form action="create.jsp">
<input type="submit" value="Create entity">
</form>
<form action="delete.jsp">
<input type="submit" value="delete entity" >
</form>
<form action="retrieve.jsp">
<input type="submit" value="retrieve entity">
</form>
</div>
</body>
</html>