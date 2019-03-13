<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<p id="demo" value='123'>Good Evening!</p>

<script>
if (new Date().getHours() < 18) {
    var v=document.getElementById("demo").value;
    alert(v);
}
</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="form1">
		<input type="text" id="id1" value="123" onblur="function1()"/>
	</form>
	
</body>
</html>