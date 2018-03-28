<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<c:if test="${loggedIn==true}">
	<c:if test="${role == 'trader'}"><c:redirect url="/viewOrders" /> </c:if>
	<c:if test="${role == 'portfoliomanager'}"><c:redirect url="PortfolioManager.jsp" /> </c:if>
</c:if>

<link rel="stylesheet" type="text/css" href="css/form.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LogIn</title>
<!-- <style type="text/css">
table  td {
	background-color: white;
	border: 1px blue;
	-webkit-border-radius: 10px; -webkit-box-shadow =5px 5px 5px black;
	-webkit-transition: -webkit-transform 2s;
}

table  tfoot td {
	color: white;
	font-weight: bold;
}</style> -->
<style>
.body{
background-image: url("1.jpg");
}
</style>
</head>
<body>
<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>XYZ <span>Co.</span></div>
		</div>
		<br>
	<form class="login" action="Login" method="post">

		<h1 align="center">Login Page</h1>
		<hr />

		<p>${msg}</p>
		<table >
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" placeholder="username"
					required="required" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"
					placeholder="password" required="required" /></td>
			</tr>
			<tr>
				<td>Access Type:</td>
				<td><input type="radio" name="accesstype"
					value="PortfolioManager" checked />Portfolio Manager <input
					type="radio" name="accesstype" value="Trader" />Trader</td>
			</tr>
			
			
				<tr><td><input type="submit" value="login" /></td></tr>
		</table>
	</form>
	<hr />
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>