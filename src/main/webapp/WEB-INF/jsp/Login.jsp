<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<div class="body"></div>
	<div class="grad"></div>
	<div class="header"></div>
	<br>
	<c:if test="${errMsg ne null}">${errMsg }</c:if>
	<form:form modelAttribute="User" class="form-horizontal" action="Login">

		<h1 align="center">Login Page</h1>
		<hr />
		<div class="container">
		<div class="row">
		<div class="col-md-4 col-md-offset-4">
		<table>
			<tr>
				<th><form:label path="userName">Username :</form:label></th>
				<td><form:input path="userName" type="text" name="userName" required="required"  placeholder="Enter username"/></td>


			</tr>
			<tr>
				<th><form:label path="password">Password :</form:label></th>
				<td><form:input path="password" type="password" name="password" required="required" placeholder="Enter password"/></td>

			</tr>
			
			<tr>
				<td align="center"><a href="ForgotPassword" class="btn">Forgot Password?</a></td>
				<td ><input class="btn" class="pull-right" type="submit"
					value="Submit"></td>
			</tr>
		</table>
		</div>
		</div>
		</div>
	</form:form>

</body>
</html>