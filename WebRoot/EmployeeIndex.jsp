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
		 		 <a href="javascript:void(0)" id="register" onclick="RecordReservation()">Record a reservation</a>
		 		 <a href="javascript:void(0)" id="register" onclick="AddFlighttoreservation()">Add Flight to reservation</a>
	   		    <a href="registerCustomer.jsp" id="registerCustomer">RegisterCustomer</a>
	   		    <a href="javascript:void(0)" id="deleteCustomer" onclick="deleteCustomer()">DeleteCustomer</a>
	   		    
	   		    <a href="javascript:void(0)" id="mailingList" onclick="mailingList()">Mailing list</a>
	   		    <a href="javascript:void(0)" id="SuggestedFlights" onclick="SuggestedFlights()">Flight suggestions for a given customer</a>
	   		    
	   		    
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
		 		<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
				  <a href="helpMenu.jsp" class="help-m">Help Menu</a>
	</div>
	
	<div id="searchByAccount"></div>
	<div id="aa">
		
	</div>
	
	
<script type="text/javascript">
function AddFlighttoreservation(){
	$('#aa').empty();
	$('#searchByAccount').empty();
	$('#searchByAccount').append("<label>Enter ReservationNo: </label>: <input class='index-home' type='text' name='ReservationNo' id='ReservationNo'><br>"
	+"<label>Enter AirlineName: </label>: <input class='index-home' type='text' name='AirlineName' id='AirlineName'><br>"
	+"<label>Enter FlightNo: </label>: <input class='index-home' type='text' name='FlightNo' id='FlightNo'><br>"
	+"<label>Enter LegNo: </label>: <input class='index-home' type='text' name='LegNo' id='LegNo'><br>"
	+"<button onclick='openAddFlighttoreservation()'>Record</button> ");
	
}
function openAddFlighttoreservation(){
	$.post(
			"${pageContext.request.contextPath}/AddFlightToReservationServlet",
			{
				'ReservationNo':$('#ReservationNo').val(),
				'AirlineName':$('#AirlineName').val(),
				'FlightNo':$('#FlightNo').val(),
				'LegNo':$('#LegNo').val()
			},
			function(data){
				alert("Recorded!")
		}) ;
}








function RecordReservation(){
	$('#aa').empty();
	$('#searchByAccount').empty();
	$('#searchByAccount').append("<label>Enter Account Number: </label>: <input class='index-home' type='text' name='accountNo' id='accountNo'><br>"
	+"<label>Enter BookingFee,: </label>: <input class='index-home' type='text' name='bookingFee' id='bookingFee'><br>"
	+"<label>Enter TotalFare: </label>: <input class='index-home' type='text' name='totalFare' id='totalFare'><br>"
	+"<label>Enter Employee SSN: </label>: <input class='index-home' type='text' name='eSSN' id='eSSN'><br>"
	+"<button onclick='openRecordReservation()'>Record</button> ");
	
}
function openRecordReservation(){
	$.post(
			"${pageContext.request.contextPath}/RecordReservationServlet",
			{
				'accountNo':$('#accountNo').val(),
				'bookingFee':$('#bookingFee').val(),
				'totalFare':$('#totalFare').val(),
				'eSSN':$('#eSSN').val()
			},
			function(data){
				alert("Recorded!")
		}) ;
}










function SuggestedFlights(){
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
				$('#searchByAccount').empty();
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

function deleteCustomer(){
	$('#aa').empty();
	$('#searchByAccount').empty();
	$('#searchByAccount').append("<label>Delete Customer By Account Number: </label>: <input class='index-home' type='text' name='accountNo' id='accountNo'><br><button onclick='opendeleteCustomer()'>Delete</button> ");
	
}
function opendeleteCustomer(){
	$.post(
			"${pageContext.request.contextPath}/deleteCustomerServlet",
			{
				'accountNo':$('#accountNo').val()
			},
			function(data){
				$('#aa').empty();
				$('#aa').append(data);
		}) ;
}
	
	</script>
	</body>
</html>
