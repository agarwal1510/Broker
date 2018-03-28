<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="java.sql.*,com.sapient.util.ConnectionUtil,java.util.*,com.sapient.survival.pojo.Order"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Open Orders Available</title>
<script>
function checkFilters(){
	var symbol = document.getElementById("symbol").value;
	var side = document.getElementById("side").value;
	if(symbol=="" && side==""){
		alert("Please enter the filters!");
		return false;
	}
}
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1 align="center">Open Orders</h1>
	<hr></hr>
	<br />
	<form action="filter" method="post">
		<input type="text" name="symbol" placeholder="enter the symbol" /> <input
			type="text" name="side" placeholder="enter the side" /> <input
			type="submit" value="search" name="search" onclick="checkFilters()"/>
	</form>
	<br />
	<br />
	<form action="newBlock" method="post">
		<%-- servlet name may change--%>
		<table border="1">
			<tr>
				<th>Select</th>
				<th>OrderId</th>
				<th>Side</th>
				<th>Symbol</th>
				<th>Total Quantity</th>
				<th>Order Type</th>
				<th>Limit Price</th>
				<th>Market Price </th>
				<th>Status</th>
				<th>Manager</th>
				<th>Portfolio</th>
			</tr>
			<%
				@SuppressWarnings("unchecked")
				List<Order> list = (List<Order>) request.getAttribute("orderList");
				for (Order o : list) {
			%>
			<tr>
				<td><input type="checkbox" name="orderId"
					value="<%=o.getOrderId()%>" /></td>
				<td><%=o.getOrderId()%></td>
				<td><%=o.getSide()%></td>
				<td><%=o.getSymbol()%></td>
				<td><%=o.getTotalQuantity()%></td>
				<td><%=o.getOrderType()%></td>
				<td><%if(o.getOrderType().equals("limitprice")){ %>
				<%=o.getLimitPrice()%>
				<%}else{ %>
				<%="-" %>
				<%} %>
				</td>
				<td><%if(o.getOrderType().equals("marketprice")){ %>
				<%=o.getExecutedPrice() %>
				<%}else{ %>
				<%="-" %>
				<%} %>
				</td>
				<td><%=o.getStatus()%></td>
				<td><%=o.getPortfolioManagerName()%></td>
				<td><%=o.getPortfolioName()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<input type="submit" value="Create Block" />&nbsp;
		<h3>
			<%
				if (request.getAttribute("message") != null) {
			%>
			<%=request.getAttribute("message")%>
			<%
				}
			%>
		</h3>
	</form>
	<hr></hr>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>