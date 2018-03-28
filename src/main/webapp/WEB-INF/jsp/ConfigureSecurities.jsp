<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.btn {
  background: #3498db;
  background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
  background-image: -moz-linear-gradient(top, #3498db, #2980b9);
  background-image: -ms-linear-gradient(top, #3498db, #2980b9);
  background-image: -o-linear-gradient(top, #3498db, #2980b9);
  background-image: linear-gradient(to bottom, #3498db, #2980b9);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 18px;
  font-family: Arial;
  color: #ffffff;
  font-size: 10px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #3cb0fd;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
}
</style>

<script>

  function clear(){
	  document.getElementById("myForm").reset();
  }
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configure Securities</title>
</head>
<body onLoad="clear()">
 


	

	
	<c:if test="${empty UserName }">
		<h3>
			<font style="color: red;"> ${notLoggedIn }</font>
		</h3>
	</c:if>
	<c:if test="${UserName ne null }">
	<h1 align="center">Configure Securities</h1>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<form:form  modelAttribute="newSecurity" class="form-horizontal" id="myForm">
				<table class="table">
					<tr>
						
						<th><form:label path="symbol">Security Symbol:</form:label></th>
						<td><form:input path="symbol" type="text" name="securitySymbol" required="required" style="text-transform: uppercase"/></td>
						
					</tr>
					<tr>
						
						<th><form:label path="name">Security Name:</form:label></th>
						<td><form:input path="name" type="text" name="securityName" required="required"/></td>

					</tr>

					<tr>
					
						<th><form:label path="lastTradedPrice">Last Traded Price:</form:label></th>
						<td><form:input path="lastTradedPrice" type="number" name="lastTradedPrice" min="1" required="required"/></td>
					</tr>
					<tr>
					
						<th><form:label path="priceSpread">Max Price spread percentage:</form:label></th>
						<td><form:input path="priceSpread" type="number" name="priceSpread" min="0" required="required"/></td>
					</tr>
					<tr>
					
						<th><form:label path="maxExecution">Max number of executions per order:</form:label></th>
						<td><form:input path="maxExecution" type="number" name="maxExecution" min="1" required="required"/></td>
					</tr>
					<tr>
					
						<th><form:label path="maxInterval">Max interval between executions in milliseconds:</form:label></th>
						<td><form:input path="maxInterval" type="number" name="maxInterval" min="1" required="required"/></td>
					</tr>
					<tr>
					
						<th><form:label path="probablePercentable">Probable percentage of fully executed orders (Number
							between 0 and 100):</form:label></th>
						<td><form:input path="probablePercentable" type="number" name="probablePercentage" min="0" max="100" required="required"/></td>
					</tr>
					<tr>
					
						<td colspan="2" align="right"><input  class="btn" type="submit"
							value="Submit"></td>
					</tr>
				</table>
			</form:form>
			<br />
			
		</div>
	
		<c:if test="${successMsg ne null }">${successMsg }</c:if>
	</div>
</c:if>
</body>
</html>