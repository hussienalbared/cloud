<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MailGun email</title>
</head>
<body>
<form action="sendgrid" method="post" >
TO:<input type="text" name="t">
<br>
subject:<input type="text" name="subjec">
<br>
text:<input type="text" name="tex">
<br>
<input type="submit" value="send"><br>
</form>
</body>
</html>