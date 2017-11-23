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
		 		 <a href="register.jsp" id="register">Record a reservation</a>
	   		    <a href="register.jsp" id="register">manage customer</a>
	   		    <a href="javascript:void(0)" id="mailingList" onclick="mailingList()">mailing list</a>
	   		    <a href="javascript:void(0)" id="SuggestedFlights" onclick="SuggestedFlights()">flight suggestions for a given customer</a>
	   		    
	   		    
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
		 		<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
				  <a href="helpMenu.jsp" class="help-m">Help Menu</a>
	</div>
	<div id="searchByAccount"></div>
	<div id="aa">
		
	</div>
	
	
<script type="text/javascript">
function SuggestedFlights(){
	$('#aa').empty();
	$('#searchByAccount').empty();
	$('#searchByAccount').append("<label>Enter Account Number: </label>: <input class='index-home' type='text' name='accountNo' id='accountNo'><br><button onclick='openSuggestedFlights()'>Search</button> ");
	
}
function openSuggestedFlights(){
	alert(1)
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


function mailingList(){
	$.post(
		"${pageContext.request.contextPath}/getMailListServlet",
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
