<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function1()
	{
		var v1=document.form1.getElementById("name").value;
		if(v1=="")
			{window.alert("Please Enter a value");}
	}
</script>
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
	<center>
	<font color="red">
		${newcustomernotinserted}
	</font>
		<font color="orange"><h1>Customer Form</h1></font>
	<form action="SignUpCustomerController" id="form1" method="post">
		<table>
			<tr><td>Name :</td><td><input type="text" name="name" id="name"  placeholder="Enter id" required/></td></tr>
			<tr><td>Address :</td><td><textarea rows="5" cols="20" name="address" placeholder="Enter address "></textarea></td></tr>
			<tr><td>Mobile Number :</td><td><input type="text" name="mobilenumber" placeholder="Enter mobilenumber"/></td></tr>
			<tr><td>Email Id:</td><td><input type="email" name="email" placeholder="Enter abc@dns.com"/></td></tr>
			<tr><td>Password:</td><td><input type="password" name="password" placeholder="Enter password"/></td></tr>
			<tr><td></td><td><input type="submit" name="submit" value="submit"/></td></tr>
			
		</table>
	</form>
	</center>
</body>
</html>