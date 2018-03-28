<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:if test="${not empty loggedIn}">
	<c:if test="${role == 'trader'}"><c:redirect url="/viewOrders" /> </c:if>
	<c:if test="${role == 'portfoliomanager'}"><c:redirect url="PortfolioManager.jsp" /> </c:if>
</c:if>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Equity Trading Simulation</title>
<style>
	body{
		background: url(1.jpg) no-repeat center center fixed; 
		-webkit-background-size: cover;
		-moz-background-size: cover;
		-o-background-size: cover;
		background-size: cover;
		filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='.myBackground.jpg', sizingMethod='scale');
		-ms-filter: "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='myBackground.jpg', sizingMethod='scale')";
	}
	
	.logo{
		  margin: 0;
		  margin-top: 20px;
		  font: bold 48px/1 "Helvetica Neue", Helvetica, Arial, sans-serif;
		  color: #fff;
		  text-shadow: 0 1px 0 #cccccc, 0 2px 0 #c9c9c9, 0 3px 0 #bbbbbb, 0 4px 0 #b9b9b9, 0 5px 0 #aaaaaa, 0 6px 1px rgba(0, 0, 0, 0.1), 0 0 5px rgba(0, 0, 0, 0.1), 0 1px 3px rgba(0, 0, 0, 0.3), 0 3px 5px rgba(0, 0, 0, 0.2), 0 5px 10px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.2), 0 20px 20px rgba(0, 0, 0, 0.15);
		  -webkit-transition: .2s all linear;
	}
</style>
</head>
<body>
	
	    <div class="container">
	    <div class="logo">
	    	XYZ co.
	    </div>    
	    <hr>
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-4 col-md-offset-4 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form id="loginform" class="form-horizontal" role="form" action="Login" method="POST">
                        		<c:if test="${not empty msg}" >
                                <div style="margin-bottom: 25px" class="alert alert-danger" role="alert">${msg}</div>    
                           		</c:if>
                           		
                           		<div style="margin-bottom: 25px" class="input-group">
                                       <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                       <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username">                                        
                                </div>
                                
	                            <div style="margin-bottom: 25px" class="input-group">
	                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                                        <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
	                            </div>
	                            <div style="margin-bottom: 25px" class="input-group">
	                            			<input type="radio" name="accesstype" value="PortfolioManager" checked /> Portfolio Manager &nbsp;&nbsp;  
											<input type="radio" name="accesstype" value="Trader" /> Trader
	                            </div>

                                <div style="margin-top:10px" class="form-group">
                                    <div class="col-sm-12 controls">
                                      <input id="btn-login" class="btn btn-success" name="submit" type="submit" value="Login" />
                                    </div>
                                </div>  
                                
                            </form>     
                        </div>                     
                    </div>  
		        </div>
		</div>
</body>
</html>