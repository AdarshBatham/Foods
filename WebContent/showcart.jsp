<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="beans.Cart" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function bill()
	{
		document.getElementById().value;
	}
	function confirmFunction()
	{
		window.alert("really want to delete");
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
<form action="GoBackToIndexShowProducts2" method="post">
	<input type="submit" value="back"/>
</form>
	<center>	
	<font color="orange">
		<h1>Products Details</h1>
	</font>

	<font color="green">
		<h1>${m2}</h1>
	</font>


		<%
		ArrayList<Cart> al=(ArrayList<Cart>)request.getAttribute("cartlist");
		
			if(al.isEmpty())
				response.sendRedirect("IndexShowProducts");
		else
			{
				%>
					<table border="1">
						<tr>
							<center><td><h3>Name</h2></td></h3></center>
							<center><td><h3>Individual Price (INR)</h3></td></center>
							<center><td><h3>Quantity</h3></td></center>
							<center><td><h3>Delete</h3></td></center>
							<center><td><h3>Total</h3></td></center>
						</tr>
						<%
						double total=0;
						double indi=0;
							for(Cart cc:al)
							{
								%>
								  <tr>
									<center><td><%=cc.getName()%></td></center>
									<center><td>Rs. <%=cc.getPrice()%></td></center>					
									<center><td><%=cc.getSumquantity()%></td></center>
									
									<%
										indi=((cc.getPrice())*(cc.getSumquantity()));
									%>
									<center>
											<td>
												<form action="DeleteCartController" method="post">
												<input type="hidden" name="hidden" value="<%=cc.getName()%>"/>
												<input type="submit" value="delete" onClick="return confirm('Really you want to add product cart')"/>
												</form>  
											</td>
									</center>
									<center><td>Rs. <%=indi%></td></center>
									
								  </tr>
								  
								<%
									
									total=total+indi;
							}
						%>
						
						
						
						
						<tr>
							<td>
								<form action="customerloginfromindex.jsp">
								
								<p align="right"><input type="submit" value="Check out now" onMouseOver="bill()"/></p>
								</form>
							</td>
							<td></td>
							<td></td>
							<td>Total Bill = </td>
							<td>
								<h3>Rs. <%=total%></h3>
							</td>
						</tr>
					</table>
				<%
			}
		%>
		
	</center>

</body>
</html>