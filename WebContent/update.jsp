<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.UpdateModel" %>
    <%@page import="model.FetchModel" %>
    <%@page import="beans.Product" %>
    <%@page import="java.util.ArrayList" %>
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
<form action="AdminLogout" method="post">
	<input type="submit" name="submit" value="logout"/>
	<a href="adminhome.jsp">back</a>
</form>
	<%
		String x=request.getParameter("x");
		HttpSession ht=request.getSession();
		ht.setAttribute("x",x);
		
		int operationid=(Integer)request.getAttribute("operationid");
		String id=(String)session.getAttribute("adminid");
		
		if(id!=null)
		{
		
		FetchModel fm=new FetchModel();
		ArrayList<Product> list=(ArrayList)fm.fetchData(operationid);
		//int huaknahi=new UpdateModel().updateData(operationid);
	%>
	<center>
	<h1>Update Product:</h1>
	 <form action="UpdateController" method="post" enctype="multipart/form-data">
	 <table>
	 <%
	 	for(Product pp:list)
	 	{
	 %>
	 <tr><td>Product Id</td><td><input type="text" name="id" value="<%=pp.getId()%> "required/></td></tr>
 <tr><td>Product Name</td><td><input type="text" name="name" value="<%=pp.getName()%>" required/></td></tr> 
 <tr><td>price</td><td><input type="text" name="price" value="<%=pp.getPrice() %>" title="only numerics + two places after decimal" required/>  </td></tr>
 <tr><td>Weight</td><td><input type="text" name="weight" value="<%=pp.getWeight()%>" required/></td></tr>
 <tr><td>Description</td><td><input type="text" name="description" value="<%=pp.getDescription()%> required"/></td></tr>
 <tr><td>Image </td><td><input type="file" name="file" accept=".jpg" value="<%=pp.getImage()%>"/></td></tr>
 <tr><td><image src="images/<%=pp.getImage()%>" height="30" width="30"/></td></tr>
 	<%
 		}
 	%>
   <tr><td><input type="submit" name="submit" value="submit"/></td></tr>
   </table>

   <%
		}
		else 
			response.sendRedirect("index.jsp");
   %>
 </form>
 </center>
</body>
</html>