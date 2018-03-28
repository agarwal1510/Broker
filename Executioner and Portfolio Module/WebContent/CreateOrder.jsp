
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Order</title>
<script type="text/javascript" src="js/mpdispscript.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1 align="center">Place New Order</h1>
	<hr>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-6">
			<form action="createorder" method="post">
				<table class="table">
					<tr>
						<th>Security Name:</th>
						<td><select name="symbol">

								<c:forEach items="${securityList }" var="entry">
									<option>
										${entry.getSymbol()}
									</option>
								</c:forEach>
						</select></td>
						
					</tr>
					<tr>
						<th>Side:</th>
						<td><select name="side">
								<option value="buy">Buy</option>
								<option value="sell">Sell</option>

						</select></td>
					</tr>
					<tr>
						<th>Quantity:</th>
						<td><input type="number" name="quantity" min="1"></td>
					</tr>
					<tr>
						<th>Order Type:</th>
						<td><select name="orderType" id="selectOrderType"
							onchange="display(this)">
								<option value="marketprice">Market Price</option>
								<option value="limitprice">Limit Price</option>
								<option value="stopprice">Stop Price</option>
								<option value="limitstop">Limit/Stop Price</option>
						</select></td>
					</tr>

					<tr id="mp">
						<th>Market Price:</th>
						<td><input type="number" name="marketprice"
							disabled="disabled"></td>
					</tr>
					<tr id="lp">
						<th>Limit Price:</th>
						<td><input type="number" name="limitprice"></td>
					</tr>
					<tr id="sp">
						<th>Stop Price:</th>
						<td><input type="number" name="stopprice"></td>
					</tr>
					
					<!-- Not Working -->
					<tr>
						<th>Trader:</th>
						<td><select name="trader">
								<c:forEach items="${TraderList }" var="entry">
								<option value="${entry.getUserId()}">${entry.getName() }/${entry.getUserId() }</option>
								</c:forEach>
							
						</select></td>
						
						    
					</tr>
					<tr>
						<td colspan="2"><input class="pull-right" type="submit"
							value="Submit"></td>
					</tr>
				</table>
			</form>
			<br/>
			<h3><c:if test="${not empty successMsg }">${successMsg }</c:if></h3>
			<h3><c:if test="${not empty errMsg }">${errMsg }</c:if></h3>
		</div>
		<div class="col-md-3"></div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>