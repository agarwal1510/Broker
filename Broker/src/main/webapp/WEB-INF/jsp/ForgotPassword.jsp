<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>
</head>
<body>
	<table >
			<tr>
				<td>New Password</td>
				<td><input type="password" name="password"
					placeholder="new-password" required="required" /></td>
			</tr>
			<tr>
				<td>Retype Password</td>
				<td><input type="password" name="password"
					placeholder="retype-password" required="required" /></td>
			</tr>
			
				<tr>
						<td colspan="2"><input class="btn" class="pull-left" type="submit"
							value="Submit"></td>
					</tr>
		</table>
</body>
</html>