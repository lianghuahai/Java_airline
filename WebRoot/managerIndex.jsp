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
		 	
	   		    <a href="registerEmploye.jsp" id="employee" >registerEmployee</a>
		 		<a href="javascript:void(0)" onclick="deleteUser()">deleteEmployee</a>
	   		    <a href="monthlyReport.jsp" id="monthlyReport" >monthlyReport</a>
	   		    <a href="javascript:void(0)" id="list_of_allFlights" onclick="report()">list of allFlights</a>
	   		    <a href="listReservation.jsp" id="list of reservations">list of reservations</a>
	   		    <a href="javascript:void(0)" id="employeeP" onclick="employeeMethod()">EmployeePerformance</a>
	   		    <a href="javascript:void(0)" id="customerP" onclick="customerMethod()">CustomerPerformance</a>
	   		    <a href="javascript:void(0)" id="MostActiveFlight" onclick="MostActiveFlight()">MostActiveFlight</a>
	   		    <a href="customerHasSeats.jsp" id="CustomerHasSeats">CustomerHasSeats</a>
	   		    <a href="flightByGivenAirport.jsp" id="flightByGivenAirport">flightByGivenAirport</a>
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
		 		<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
	 			
	  <a href="helpMenu.jsp" class="help-m">Help Menu</a>
	</div>
	<div id="aa">
		
	</div>
	
	
<script type="text/javascript">
function deleteUser(){
	$('#aa').append("<label>Enter the employee number to be deleted: </label>: <input class='index-home' type='text' name='employeeID' id='employeeID'><br><button onclick='openDelete()'>Delete</button> ");
	
}
function openDelete(){
	$.post(
			"${pageContext.request.contextPath}/deleteEmployeeServlet",
			{
				'employeeID':$('#employeeID').val()
			},
			function(data){
				alert("Delete Successful!")
		}) ;
}
function MostActiveFlight(){
	$.post(
		"${pageContext.request.contextPath}/findMostActiveFlightServlet",
		{
			
		},
		function(data){
			$('#aa').empty();
			$('#aa').append(data);
	}) ;
}
function customerMethod(){
	$.post(
		"${pageContext.request.contextPath}/findCustomerPormanceServlet",
		{
			
		},
		function(data){
			$('#aa').empty();
			$('#aa').append(data);
	}) ;
}
	function employeeMethod(){
		$.post(
			"${pageContext.request.contextPath}/findEmployeePerformanceServlet",
			{
				
			},
			function(data){
				$('#aa').empty();
				$('#aa').append(data);
		}) ;
	}
	function report(){
		
		$("#aa").load(
			"${pageContext.request.contextPath}/listAllFlightServlet",
			{
				
			},
			function(data){
		}) ;
	}
	
	</script>
	</body>
</html>
