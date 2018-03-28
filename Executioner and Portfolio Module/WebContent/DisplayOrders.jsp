<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page session="true"%>
<%@page import="java.io.*"%>
<%@page import="java.net.*"%>
<%@page import="javax.servlet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty loggedIn }">
	<c:redirect url="/Login.jsp" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders In Block</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${not empty Blocklist }">
	<h1><b>Order Details</b></h1>
		<table border=1>
			<tr>
				<td>symbol</td>
				<td>side</td>
				<td>total quantity</td>
				<td>allocated quantity</td>
				<td>order type</td>
				<td>executed price</td>
				<td>status</td>
			</tr>

			<c:forEach var="blk" items="${Blocklist}">
				<tr>
					<td>${blk.getSymbol() }</td>
					<td>${blk.getSide() }</td>
					<td>${blk.getTotalQuantity() }</td>
					<td>${blk.getAllocatedQuantity() }</td>
					<td>${blk.getOrderType() }</td>
					<td>${blk.getExecutedPrice() }</td>
					<td>${blk.getStatus() }</td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>