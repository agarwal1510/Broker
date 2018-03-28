<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Order</title>
<style>
#div1 {
	float: right;
}

#selectside {
	float: left;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<h1 align="center">View Order</h1>
	<hr />
	<br>
	<form action="#" method="GET">
		<select name="side" id="side">
			<option value="">-Select-</option>
			<option value="buy">Buy</option>
			<option value="sell">Sell</option>
		</select>
		<div id="div1">
			<input type="text" name="symbol" placeholder="Enter Symbol">
			<input type="submit" value="Search">
		</div>
	</form>


	<table class="table" border="1">
		<tr>
			<th>Order Id</th>
			<th>Security Name</th>
			<th>Side</th>
			<th>Quantity</th>
			<th>Order Type</th>
			<th>Limit Price</th>
			<th>Stop price</th>
			<th>Quantity Allocated</th>
			<th>Open Quantity</th>
			<th>Trader</th>
			<th>Status</th>
			<th></th>
		</tr>
		<c:forEach items="${list}" var="entry">
			<tr>
				<td>${entry.getOrderId() }</td>
				<td>${entry.getSymbol() }</td>
				<td>${entry.getSide() }</td>
				<td>${entry.getTotalQuantity()}</td>
				<td>${entry.getOrderType() }</td>
				<td>${entry.getLimitPrice() }</td>
				<td>${entry.getLimitPrice() }</td>
				<td>${entry.getAllocatedQuantity() }</td>
				<td>${entry.getTotalQuantity() - entry.getAllocatedQuantity() }</td>
				<td>${entry.getTrader() }(${entry.getTraderId() })</td>
				<td>${entry.getStatus() }</td>
				<td><c:if test="${ entry.getStatus() eq 'new' }">
						<a href="delete?order_id=${entry.getOrderId() }">Delete</a>
					</c:if></td>
			</tr>
		</c:forEach>

	</table>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>