
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="beans.Customer_Cart" %>
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
<form action="customerhome.jsp" >
		<input type="submit" name="submit" value="back"/>
	</form>

	<%
		Customer_Cart cc=(Customer_Cart)request.getAttribute("customerupdateprofile(Details)");
	 %>
	 <center>
	<form action="CustomerGivenDetailsUpdateNow" method="post">
		<h1><font color="orange">Update Details of Customer</font></h1>
		<table>
			<tr><td>Id</td><td><input type="text" name="id" value="<%=cc.getId()%>" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" readonly/></td></tr>
			<tr><td>Email</td><td><input type="email" name="email" value="<%=cc.getEmail()%>" /></td></tr>
			<tr><td>First Name</td><td><input type="text" name="firstname" value="<%=cc.getFirstname() %>"/></td></tr>
			<tr><td>Last Name</td><td><input type="text" name="lastname" value="<%=cc.getLastname() %>"/></td></tr>
			<tr><td>Address1</td><td><input type="text" name="address1" value="<%=cc.getAddress1() %>"/></td></tr>
			<tr><td>Address2</td><td><input type="text" name="address2" value="<%=cc.getAddress2() %>"/></td></tr>
			<tr><td>Zip/Postal Code</td><td><input type="text" name="postalcode" value="<%=cc.getPostalcode() %>"/></td></tr>
			<tr><td>City</td><td><input type="text" name="city" value="<%=cc.getCity() %>"/></td></tr>
			<tr><td>State</td><td><input type="text" name="state" value="<%=cc.getState() %>"/></td></tr>
			<tr><td>Mobile Number</td><td><input type="text" name="mobilenumber" value="<%=cc.getMobilenumber() %>"/></td></tr>
			<tr><td>Password</td><td><input type="text" name="password" value="<%=cc.getPassword() %>"/></td></tr>
			 <tr><td></td><td><input type="submit" name="submit" value="save"/><input type="submit" name="cancel" value="cancel"/></td></tr>
		</table>	
		</form>
	</center>
</body>
</html>