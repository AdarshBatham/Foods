<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="beans.Product" %>
    <%@page import="beans.Cart" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css" />
	<link rel="stylesheet" href="mystyle.css" />
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">



	<script type="text/javascript">
	function function1()
	{
	var a=confirm("Show Cart???");
	alert(a);
		if(a)
			{
			window.open("ShowCartController");
			}
	}
	
	function function2()
	{
		
	}
</script>
</head>
<body>
${show_description }
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
			<li ><a href="IndexShowProducts">Products</a></li>
			<li ><a href="ShowCartController">Show Cart</a></li>
			
			
			</ul>
			</div>
			</nav>
			
			
			</div>
			</div>
			</div>
			

<div class="container">
			<div class="row">


${invalidquantity}
	<form action="index.jsp" >
		<input type="submit" name="submit" value="back"/>
	</form>	
	<%
	ArrayList<Cart> calculated_values=(ArrayList)request.getAttribute("calculated_values");
	%>
	<p align="right">
		<%
			if(calculated_values.isEmpty())
			{}
			else
			{
				for(Cart c:calculated_values)
				{
					%>
					<table align="right" border="1">
					<tr>
					  
						<td>Quantity=<%=c.getSumquantity()%></td>
						</tr>
						
						<tr>
						<td>Total Price=<%=c.getTotalprice()%></td>
					  
					</tr>
					</table>
					<%
				}
			}
		%>
	</p>
					
<center>	
			<font color="orange">
				<h1>Products Details</h1>
			</font>
			
			<font color="green">
				<h1>${m2}</h1>
				<h1>${invalidselection}</h1>
			</font>




	<%
	
	
		ArrayList<Product> al=(ArrayList)request.getAttribute("arraylist");
		if(al!=null)
		{	int a=0;
			%><table border="2"><%
			for(Product l:al)
			{
					if(a%4==0)
					{
					out.println("<tr>");
				    %>
					<td>
					<form action="AddToCartController" method="post">
								
						<center><h4><%=l.getName()%></h4><br/></center>
						<center>Price  = <%=l.getPrice()%> Rs.<br/></center>
						<center>Weight = <%=l.getWeight()%> gms.<br/></center>
						<center><%=l.getDescription()%><br/></center>
						<center><image src="images/<%=l.getImage()%>" height="90" width="90"/><br/></center>
						<center><input type="hidden" value="<%=l.getId()%>" name="hidden1"/><br/></center>
						<!-- <center><input type="number" min="1" max="10" value="1" name="productquantity"/><br/></center> -->
						<center><input type="number" name="productquantity" value="1" min="1" required/><br/></center>
						<center><input type="submit" value="Add to cart" name="submit" onClick="return confirm('Really you want to add product cart')" /><br/></center>
						
					</form>
					
								<form action="ViewProductDescriptionController" method="post">
									<input type="hidden" value="<%=l.getId()%>" name="id"/><br/>
									<input type="submit" value="View Details" name="submit"/>									
								</form>
						
				</td>
			<%
					}else{
						%>
						<td>
							<form action="AddToCartController" method="post">
										
								<center><h4><%=l.getName()%></h4><br/></center>
								<center>Price  = <%=l.getPrice()%> Rs.<br/></center>
								<center>Weight =<%=l.getWeight()%> gms.<br/></center>
								<center><%=l.getDescription()%><br/></center>
								<center><image src="images/<%=l.getImage()%>" height="90" width="90"/><br/></center>
								<center><input type="hidden" value="<%=l.getId()%>" name="hidden1"/><br/></center>
								<center><input type="number" name="productquantity" value="1" min="1" required/><br/></center>
								<center><input type="submit" value="Add to cart" name="submit" onClick="return confirm('Really you want to add product cart')"/><br/></center>
							</form>
							<form action="ViewProductDescriptionController" method="post">
									<center><input type="hidden" value="<%=l.getId()%>" name="id"/><br/></center>
									<center><input type="submit" value="View Details" name="submit"/></center>								
							</form>
						</td>
						
						<%
					if(a%4==3)
						out.println("</tr>");
					    	
				    }		
					a++;

				}
									
		    
		%>
				</table>				
			<%
		}
	%>
</center>
</div>
</div>
		<script type="text/javascript" src="js/jquery.js"> </script>	
	<script type="text/javascript" src="js/bootstrap.js"></script>	
</body>
</html>