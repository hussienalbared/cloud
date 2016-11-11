<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script language="javascript">
var i=0;


function myFunction(){

var element=document.createElement("input");
var element2=document.createElement("input");
element.setAttribute("type", "text");
element2.setAttribute("type", "text");
	var foo = document.getElementById("f1");
	
	element.setAttribute("name", "pro"+i);
	element2.setAttribute("name", "val"+i);
	var hidd = document.getElementById("count");
	hidd.setAttribute("value",i+1);
	
foo.appendChild(element);

foo.appendChild(element2);
i=i+1;

}
function myFunction2(){
 var myForm = document.getElementById("f1");
    //Extract Each Element Value
    for (var i = 0; i < myForm.elements.length; i++) {
    document.write(myForm.elements[i].value+"<br>");
    }

}

</script>


</head>
<body>
<%
int y=0;
%>
<form id="f1" action="create" method="post" >
<input type="hidden" name="count" id="count">
<label style="width:100px;margin-left:30px;">Property</label><label style="width:100px;margin-left:100px;">      value</label><br>
kind:<input type="text" name="kind"> key:<input type="text" name="key"><br>
<button id="b1" type="button" onclick="myFunction()">add property</button>



<br>
<input type="submit">
</form>
</body>
</html>