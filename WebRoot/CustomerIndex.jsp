<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/mystyle.css"> 
</head>
  <body class="register">
	 <!-- Navigation Bar -->
	 <div class="mystyle-navbar">
				  <a href="javascript:void(0)" onclick="BestSellerFlight()">Best-Seller list of flights</a>
				  	<a href="javascript:void(0)" >Flight Suggestion</a>
				  <a href="javascript:void(0)" id="autions">Autions</a>
				  <a href="javascript:void(0)" onclick="SuggestedFlight()">My Flight History</a>
				  
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
			 	<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
			 	<a href="helpMenu.jsp" class="help-m">Help Menu</a>
	</div>
	
	<div id="searchByAccount"></div>
	<div id="aa">
		
	</div>
	
	
<script type="text/javascript">
function SuggestedFlight(){
	$('#aa').empty();
	$('#searchByAccount').empty();
	$('#searchByAccount').append("<label>Enter Account Number: </label>: <input class='index-home' type='text' name='accountNo' id='accountNo'><br><button onclick='openSuggestedFlights()'>Search</button> ");
	
}
function openSuggestedFlights(){
	$.post(
			"${pageContext.request.contextPath}/SuggestedFlightsServlet",
			{
				'accountNo':$('#accountNo').val()
			},
			function(data){
				alert(data)
				$('#aa').empty();
				$('#aa').append(data);
		}) ;
}
function BestSellerFlight(){
	$.post(
		"${pageContext.request.contextPath}/BestSellerFlightsServlet",
		{
			
		},
		function(data){
			$('#aa').empty();
			$('#searchByAccount').empty();
			$('#searchByAccount').append(data);
	}) ;
}

	
	</script>
	</body>
</html>
