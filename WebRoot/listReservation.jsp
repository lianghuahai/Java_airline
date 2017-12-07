<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/mystyle.css"> 
</head>
<body class="register" id="aa">
 <div class="mystyle-navbar">
		 	
	   		   <a href="registerEmploye.jsp" id="employee" >employee</a>
	   		    <a href="monthlyReport.jsp" id="monthlyReport" >monthlyReport</a>
	   		    <a href="javascript:void(0)" id="list_of_allFlights" onclick="report()">list of allFlights</a>
	   		    <a href="listReservation.jsp" id="list of reservations">list of reservations</a>
	   		    <a href="javascript:void(0)" id="employeeP" onclick="employeeMethod()">EmployeePerformance</a>
	   		    <a href="javascript:void(0)" id="customerP" onclick="customerMethod()">CustomerPerformance</a>
	   		    <a href="javascript:void(0)" id="MostActiveFlight" onclick="MostActiveFlight()">MostActiveFlight</a>
	   		    <a href="customerHasSeats.jsp" id="CustomerHasSeats">CustomerHasSeats</a>
	   		    <a href="flightByGivenAirport.jsp" id="flightByGivenAirport">flightByGivenAirport.jsp</a>
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
		 		<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
	 
	  <a href="helpMenu.jsp" class="help-m">Help Menu</a>
	</div >
		<div id="date">
	      <label> Airline Name: </label>
	      <input class="index-home" type="text"  name="airlineName" id="airlineName">
	
	      <label> flight Number: </label>
	      <input class="index-home" type="text"  name="flightNo" id="flightNo">
	    </div>
	    <a href="javascript:void(0)" onclick="SearchByFlght()">SearchByFlght:</a>
	    <div id="SearchByFlght">
	    	<c:forEach var="flightInfo" items="${listByFlight}">
	    			${flightInfo.airlineName}
	    			${flightInfo.flightNo}
	    			${flightInfo.reservationDate}
	    			${flightInfo.totalFare}
	    			${flightInfo.accountNo}
	    			${flightInfo.bookingFee}<br>
	    		</c:forEach>
	    </div>
	    
		<div id="date">
	      <label> First Name: </label>
	      <input class="index-home" type="text"  name="firstName" id="firstName">
	
	      <label> Last Number: </label>
	      <input class="index-home" type="text"  name="lastName" id="lastName">
	    </div>
	    <a href="javascript:void(0)" onclick="SearchByCustomer()">SearchByCustomer:</a>
	    
	     <div id="SearchByCustomer">
	     <c:forEach var="flightInfo" items="${listByCustomer}">
	    			${flightInfo.firstName}
	    			${flightInfo.lastName}
	    			${flightInfo.reservationDate}
	    			${flightInfo.totalFare}
	    			${flightInfo.accountNo}
	    			${flightInfo.bookingFee}<br>
	    		</c:forEach>
	    </div>
	    
	    
		<div id="date">
	      <label>  Destination city: </label>
	      <input class="index-home" type="text"  name="dcity" id="dcity">
	    </div>
	    <a href="javascript:void(0)" onclick="SearchBydcity()">Search By Destination City:</a>
	    
	     <div id="SearchByCustomer">
	     <c:forEach var="flightInfo" items="${listBydcity}">
	    			${flightInfo.destinationCity}
	    			${flightInfo.reservationNo}
	    			${flightInfo.bookingFee}<br>
	    		</c:forEach>
	    </div>

<script type="text/javascript">
function SearchBydcity(){
	alert(1)
	$("#aa").load(
		"${pageContext.request.contextPath}/searchByDCityServlet",
		{
			'dcity':$('#dcity').val()
			
		},
		function(data){
		}) ;
}
function SearchByFlght(){
	$("#aa").load(
		"${pageContext.request.contextPath}/searchByFlghtServlet",
		{
			'airlineName':$('#airlineName').val(),
			'flightNo':$('#flightNo').val()
		},
		function(data){
		}) ;
}
function SearchByCustomer(){
	$("#aa").load(
		"${pageContext.request.contextPath}/searchByCustomerServlet",
		{
			'lastName':$('#lastName').val(),
			'firstName':$('#firstName').val()
		},
		function(data){
		
	}) ;
}



</script>
</body>
</html>