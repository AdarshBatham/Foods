<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="beans.Cart" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String email=(String)session.getAttribute("customersession"); 
		if(email!=null)
		{
	%>
	<form action="CustomerLogout" method="post">
	<table>
		<tr><td><input type="submit" name="submit" value="logout"/></td></tr>
		<a href="">back</a>
	</table>
	</form>
	<center>
		<font color="orange">
		<h1>Customer Home</h1>
		</font>



			<a href="PendingProductsController"><h3>view pending products</h3></a>
			<% 
ArrayList<Cart> al=(ArrayList)request.getAttribute("unorderedproducts");

if(al!=null)
{
	
	%>
	<table border="1">
	<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Price</td>
				<td>Weight</td>
				<td>Description</td>
				<td>Image</td>
				
				<td>Quantity</td>
				<td>Date Only</td>
				<td>Sum Quantity</td>
				<td>Sum Price</td>
				<td>Status</td>
				
			</tr>
	
	<%
		for(Cart cc:al)
		{
		%>
			<tr>
				<td><%=cc.getId() %></td>
				<td><%=cc.getName() %></td>
				<td><%=cc.getPrice() %></td>
				<td><%=cc.getWeight() %></td>
				<td><%=cc.getDescription() %></td>
				<td><%=cc.getImage()%></td>
				
				<td><%=cc.getQuantity()%></td>
				<td><%=cc.getDateonly()%></td>
				<td><%=cc.getSumquantity()%></td>
				<td><%=cc.getSumprice()%></td>
				<td><%=cc.getStatus()%></td>
				<td><a href="">buy product</a>			
			</tr>
		<%
		}
	%>
	</table>
	<%
}
%>
</center>	
				<%
				}
		else 
			response.sendRedirect("customerlogin.jsp");
		%>	
</body>
</html>