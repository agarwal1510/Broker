<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<link rel="stylesheet" href="css/table.css">
<title>Equity Trading Simulation</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/justified-nav.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="container">

		<div class="masthead">
			<h2 class="text-muted">Equity Based Simulation</h2>
			<nav>
				<h3>
					<a>Hello ${username }</a>
				</h3>
				<ul class="nav nav-justified">

					<c:if test="${role=='portfoliomanager' }">
						<li><a href="PortfolioManager.jsp">Home</a></li>
					</c:if>
					<c:if test="${role=='portfoliomanager' }">
						<li><a href="ViewPortfolio.jsp">View PortFolio</a></li>
					</c:if>
					<c:if test="${role=='portfoliomanager' }">
						<li><a href="placeOrder">Create Order</a></li>
					</c:if>
					<c:if test="${role=='portfoliomanager' }">
						<li><a href="viewOrder">View Order</a></li>
					</c:if>
					<c:if test="${role=='trader' }">
						<li><a href="viewOrders">View Open Orders</a></li>
					</c:if>
					<c:if test="${role=='trader' }">
						<li><a href="viewBlocks">View Blocks</a></li>
					</c:if>
					<c:if test="${not empty loggedIn }">
						<li><a href="Logout.jsp">Logout</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
