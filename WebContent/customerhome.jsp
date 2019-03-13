<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="mystyle.css" />
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

</head>
<body>
<div class="container">
			<div class="row">
			<div class="col-sm-5">
			<img src="images/zappyimage.png" alt=""></img>
			</div>
			
			
			<div class="col-sm-7 my_menu">
			<nav class="navbar navbar-default">
			<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynavbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
			</div>
			
			
			<div class="collapse navbar-collapse" id="mynavbar">
			<ul class="nav navbar-nav pull-right">
			<li ><a href="index.jsp">Home</a></li>
			
			
			
			
			</ul>
			</div>
			</nav>
			
			
			</div>
			</div>
			</div>
${customerlogin}
${orderplaced}
<!-- ${changingcustomerpassword} -->
	<form action="CustomerLogout" method="post">	
		<input type="submit" name="submit" value="logout"/>
	</form>	
	
	
	<center>
		<font color="orange">
		<h1>Customer Home</h1>
		</font>	
	</center>
	<%
		String email=(String)session.getAttribute("customersession"); 
		if(email!=null)
		{
	%>
	
	<center>
		<table>			
			<tr><td><form action="customerchangepassword.jsp" method="post"><input type="submit" value="Change Password"/></form></td></tr>
			<tr><td><form action="CustomerUpdateProfileController" method="post"><input type="submit" value="Update Details"/></form></td></tr>
			<tr><td><form action="PendingProductsController" method="post"><input type="submit" value="view pending products"/></form></td></tr>
			<tr><td><form action="PlacedOrdersController" method="post"><input type="submit" value="View Dispatched orders"/></form></td></tr>
			
			
			<tr><td><form action="ViewAllOrdersController" method="post"><input type="submit" value="View All Orders"/></form></td></tr>
<!-- 		<tr><td><a href="PendingProductsController">view pending products</a></td></tr>-->
		</table>	
	</center>
	<%
		}
		else 
			response.sendRedirect("customerlogin.jsp");
		%>	
	
</body>
</html>