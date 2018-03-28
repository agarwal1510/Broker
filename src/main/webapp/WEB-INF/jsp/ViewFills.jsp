<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Fills</title>
</head>
<body bgcolor="#e3e3e3">

	
	
	<c:if test="${empty UserName }">
		<h3>
			<font style="color: red;"> ${notLoggedIn }</font>
		</h3>
	</c:if>
	<c:if test="${UserName ne null }">
	<h1 align="center">View Fills</h1>
		<c:if test="${empty fillList }">Fill List is empty!!!</c:if>
		<c:if test="${!empty fillList }">
			<table class="table" border="1">

				<tr>
					<th>FillId</th>
					<th>BlockId</th>
					<th>Quantity</th>
					<th>Executed Price</th>
				</tr>
				<c:forEach items="${fillList}" var="fill">
					<tr>
						<td>${fill.getFillId()}</td>
						<td>${fill.getBlockId()}</td>
						<td>${fill.getExecutedQuantity()}</td>
						<td>${fill.getExecutedPrice()}</td>

					</tr>

				</c:forEach>
			</table>
			<div align="right">
				<c:if test="${page>1 }">
					<a href="/Broker/ViewFills?page=${page -2}">Previous 10 Fills</a>
				</c:if>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${empty next }">
					<a href="/Broker/ViewFills?page=${page }">Next 10 Fills</a>
				</c:if>
				
			</div>
		</c:if>
	</c:if>

</body>
</html>