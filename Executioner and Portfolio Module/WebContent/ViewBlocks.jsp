<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="java.sql.*,com.sapient.util.ConnectionUtil,java.util.*,com.sapient.survival.pojo.Block"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/table.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blocks Available</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1 align="center">Existing Blocks</h1>
	<hr></hr>
	<c:if test="${not empty blockList }">
		<form action="changeStatus" method="post">
			<table border=1>
				<tr>
					<th>Select</th>
					<th>Block Id</th>
					<th>Trader Id</th>
					<th>Side</th>
					<th>Symbol</th>
					<th>Total Quantity</th>
					<th>Allocated Quantity</th>
					<th>Average Price</th>
					<th>Status</th>
					<th>View Details</th>

				</tr>
				<%
					@SuppressWarnings("unchecked")
						List<Block> list = (List<Block>) request
								.getAttribute("blockList");
						for (Block b : list) {
				%>
				<tr>
					<td>
						<%
							if (b.getStatus().equalsIgnoreCase("new")) {
						%> <input type="checkbox" name="blockId"
						value="<%=b.getBlockId()%>" /> <%
 	} else {
 %> <%="-"%> <%
 	}
 %>
					</td>
					<td><%=b.getBlockId()%></td>
					<td><%=b.getTraderId()%></td>
					<td><%=b.getSide()%></td>
					<td><%=b.getBlockSymbol()%></td>
					<td><%=b.getTotalQuantity()%></td>
					<td><%=b.getAllocatedQuantity()%></td>
					<td><%=b.getAvgPrice()%></td>
					<td><%=b.getStatus()%></td>
					<td><a target="_blank"
						href="ViewOrders1?bid=<%=b.getBlockId()%>">View</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<input type="submit" name="send for execution"
				value="send for execution" />
		</form>
	</c:if>
	<c:if test="${empty blockList }">No Blocks YET .</c:if>
	<hr></hr>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>






