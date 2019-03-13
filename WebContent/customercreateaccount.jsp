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
<form action="customerloginfromindex.jsp" method="post">
		<input type="submit" name="submit" value="back"/>
</form>
<form action="index.jsp" method="post">
		<input type="submit" name="submit" value="jump to index"/>
</form>
	<center>
	<form action="SignUpCustomerControllerFromCart" method="post">
		<h1><font color="orange">New Customer</font></h1>
		<table>
			
			<tr><td>Email</td><td><input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required/></td></tr>
			<tr><td>First Name</td><td><input type="text" name="firstname" pattern="[A-Za-z]+" title="only alphabet" required/></td></tr>
			<tr><td>Last Name</td><td><input type="text" name="lastname" pattern="[A-Za-z]+" title="only alphabet" required/></td></tr>
			<tr><td>Address1</td><td><input type="text" name="address1" required/></td></tr>
			<tr><td>Address2</td><td><input type="text" name="address2" required/></td></tr>
			<tr><td>Zip/Postal Code</td><td><input type="text" name="postalcode" pattern="[4-6]{1}[0-9]{5}" maxlength="6" title="Please use only numeric and first digit must be 4 or 5 or 6" required/></td></tr>
			<tr><td>City</td><td><input type="text" name="city" pattern="[A-Za-z]+" title="only alphabet" required/></td></tr>
			<tr><td>State</td><td><input type="text" name="state" pattern="[A-Za-z]+" title="only alphabet" required/></td></tr>
			<tr><td>Mobile Number</td><td><input type="text" name="mobilenumber" pattern="[7-9]{1}[0-9]{9}" maxlength="10" title="Please only use numeric" required/></td></tr>
			<tr><td>Password</td><td><input type="password" name="password1" required/></td></tr>
			<tr><td>Confirm Password</td><td><input type="password" name="password2" required/></td></tr>
			 <tr><td></td><td><input type="submit" name="submit" value="save"/><input type="submit" name="cancel" value="cancel"/></td></tr>
		</table>	
		</form>
	</center>
</body>
</html>