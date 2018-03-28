<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<li><a href="<spring:url value="/ConfigureSecurities"/>">Configure Securities</a></li>
<li><a href="<spring:url value="/ViewSecurities"/>">View Securities</a></li>
<li><a href="<spring:url value="/ViewFills"/>">View Fills</a></li>
<li><a href="<spring:url value="/Exchange"/>">Exchange</a></li>
<li>
	<c:if test="${UserName ne null }"><a href="<spring:url value="/Logout"/>">${UserName } Logout</a></c:if>
	<c:if test="${empty UserName }"><a href="<spring:url value="/Login"/>">Login</a></c:if>
</li>
