<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Securities</title>
</head>
<body bgcolor="#e3e3e3">

	<h1 align="center">View Securities</h1>

	<c:if test="${empty securityList }">Securities List is empty!!!</c:if>
	<c:if test="${!empty securityList }">
		<table class="table" border="1">

			<tr>
				<th>Security Symbol</th>
				<th>Security Name</th>
				<th>Last Traded Price(Rs.)</th>
			</tr>
			<c:forEach items="${securityList}" var="security">
				<tr>
					<td>${security.getSymbol()}</td>
					<td>${security.getName()}</td>
					<td>${security.getLastTradedPrice1()}</td>
				</tr>

			</c:forEach>
		</table>
	</c:if>

</body>
</html>