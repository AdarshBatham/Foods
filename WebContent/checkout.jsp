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
<font color="red">
		${newcustomernotinserted}
		${orderplaced}
		${newcustomerinserted}
		<a href="indexshowproducts2.jsp">back</a>
	
	</font>
	<center>
		<form action="customerloginfromindex.jsp" method="post">
			<tr><td><input type="submit" name="operation" value="Customer Sign In" /></td></tr>
		</form>
		
		
		<!--  <form action="SignUpCustomerControllerFromCart" method="post">-->
		<form action="SignUpCustomerControllerFromCart" method="post">
		<h1><font color="orange">Your account details</font></h1>
		<table>
			
			<tr><td>Email</td><td><input type="email" name="email" required/></td></tr>
			<tr><td>First Name</td><td><input type="text" name="firstname" required/></td></tr>
			<tr><td>Last Name</td><td><input type="text" name="lastname" required/></td></tr>
			<tr><td>Address1</td><td><input type="text" name="address1" required/></td></tr>
			<tr><td>Address2</td><td><input type="text" name="address2" required/></td></tr>
			<tr><td>Zip/Postal Code</td><td><input type="text" name="postalcode" required/></td></tr>
			<tr><td>City</td><td><input type="text" name="city" required/></td></tr>
			<tr><td>State</td><td><input type="text" name="state" required/></td></tr>
			<tr><td>Mobile Number</td><td><input type="text" name="mobilenumber" required/></td></tr>
			<tr><td>Password</td><td><input type="password" name="password1" required/></td></tr>
			<tr><td>Confirm Password</td><td><input type="password" name="password2" required/></td></tr>
			 <tr><td><input type="submit" name="submit" value="save"/></td><td><input type="submit" name="cancel" value="cancel"/></td></tr>
		</table>	
		</form>
	</center>
</body>
</html>