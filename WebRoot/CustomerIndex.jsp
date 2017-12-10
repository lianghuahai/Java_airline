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
  <body class="register" id="aa">
	 <!-- Navigation Bar -->
	 <div class="mystyle-navbar">
	  <a href="CustomerIndex.jsp" class="selected" id="CustomerIndex">Home</a>
	  <a href="javascript:void(0)"  id="index" onclick="roundTrip()">RoundTrip</a>
				  <a href="javascript:void(0)" onclick="BestSellerFlight()">Best-Seller list of flights</a>
				  	<a href="javascript:void(0)" onclick="SuggestedFlight()">Flight Suggestion</a>
				  <a href="javascript:void(0)" id="autions">Autions</a>
				  <a href="javascript:void(0)" onclick="mylighthistory()">My Flight History</a>
				  <a href="javascript:void(0)" onclick="itinerary()">itinerary </a>
				  
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
			 	<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
			 	<a href="https://docs.google.com/document/d/1cDQ7wf3MznF1shG0xC4w5f0sY1nZPyaPBpuYDNikAdA/edit?usp=sharing" class="help-m">Help Menu</a>
	</div>
	<div class="content" id="formclear">
			    <h2 >Search your flight</h2>
			  <div class="search">
			  <form action="searchFlightServlet" method="post" accept-charset=utf-8>
			    <div id="date" >
			      <label> From: </label>
			      <input class="index-home" type="date" placeholder="DD MM YYYY" name="departDate" id="departDate">
			
			    </div>
			    <div id="location">
			      <label> Departure City: </label>
			      <input class="index-home" type="text" placeholder="Departure City" name="departCity" id="departCity">
			  
			      <label> Arrival City: </label>
			      <input  class="index-home" type="text" placeholder="Arrival City" name="arriveCity" id="arriveCity">
			    </div>
			    <div id="passenger">
			      <label> Adults </label>
			      <input class="index-home" type="text"  maxlength="3" name="adults" id="adults" ">
			 
			      <label> Kids </label>
			      <input class="index-home" type="text" maxlength="3" name="kids" id="kids">
			    </div>
			      <label> Class </label>
			      <!-- <input class="in" type="text" placeholder="Economy" name="classLevel" id="classLevel"> -->
					    <select class="index-home"  name="classLevel" id="classLevel">
						  <option class="index-home" value="economy" selected id="economy">Economy</option>
						  <option class="index-home" value="bussiness"  id="bussiness">Bussiness</option>
						  <option class="index-home" value="first"  id="first">First</option>
						</select>
	    		<label> Preferred airline </label>
			              <select class="index-home"  name="preferAirline" id="preferAirline">
			                <option selected="selected" value=""> No preference</option>
			              	<option value="Air Berlin">Air Berlin</option>
			              	<option value="United Airlines">United Airlines</option>
			              	<option value="Air Japan">Air Japan</option>
			              	<option value="Air Madagascar">Air Madagascar</option>
			              	<option value="American Airlines">American Airlines</option>
			              	<option value="British Airways">British Airways</option>
			              	<option value="Delta Airlines">Delta Airlines</option>
			              	<option value="JetBlue Airways">JetBlue Airways</option>
			              	<option value="Lufthansa">Lufthansa</option>
			              	<option  value="Southwest Airlines">Southwest Airlines</option>
			              </select>
			      <br>
			      <button class="btn-sh" type="submit" onclick="return checkNull()">Search</button>
			      <button class="btn-sh" style="margin-left: 150px;" onclick="roundTrip()">Search flexible Time</button>
			       </form>
			  </div>
			</div>
	<div id="searchByAccount"></div>
	<div id="aa">
		
	</div>
	<span id="userID" style="display: none;">${existUser.id}</span>
	
<script type="text/javascript">

function sft(){
	alert("SearchFlightOneWayFlex")
	$("#aa").load(
		"${pageContext.request.contextPath}/SearchFlightOneWayFlex",
		{
			'departDate':$('#departDate').val(),
			'departCity':$('#departCity').val(),
			'arriveCity':$('#arriveCity').val(),
			'adults':$('#adults').val(),
			'kids':$('#kids').val(),
			'classLevel':$('#classLevel').val(),
		},
		function(data){
			
	}) ;
}



function roundTrip(){
	$('#formclear').empty();
	$("#formclear").load(
		"${pageContext.request.contextPath}/roundTrip.jsp",
		{
			
		},
		function(data){
			alert(OK)
	}) ;
}




function itinerary(){
	$('#aa').empty();
	$('#formclear').empty();
	$('#searchByAccount').empty();
	$('#searchByAccount').append("<label>Enter Reservation Number: </label>: <input class='index-home' type='text' name='reservationNo' id='reservationNo'><br><button onclick='openitinerary()'>Search</button> ");
	
}
function openitinerary(){
	$.post(
		"${pageContext.request.contextPath}/ItineraryServlet",
		{
			'reservationNo': $('#reservationNo').val()
		},
		function(data){
			$('#aa').empty();
			$('#formclear').empty();
			$('#searchByAccount').empty();
			$('#searchByAccount').append(data);
	}) ;
}

















function SuggestedFlight(){
	$('#aa').empty();
	$('#formclear').empty();
	$('#searchByAccount').empty();
	$('#searchByAccount').append("<label>Enter Account Number: </label>: <input class='index-home' type='text' name='accountNo' id='accountNo'><br><button onclick='openSuggestedFlights()'>Search</button> ");
	
}
function openSuggestedFlights(){
	$.post(
		"${pageContext.request.contextPath}/SuggestedFlightsServlet",
		{
			'accountNo': $('#accountNo').val()
		},
		function(data){
			$('#aa').empty();
			$('#formclear').empty();
			$('#searchByAccount').empty();
			$('#searchByAccount').append(data);
	}) ;
}













function BestSellerFlight(){
	$.post(
		"${pageContext.request.contextPath}/BestSellerFlightsServlet",
		{
			
		},
		function(data){
			$('#aa').empty();
			$('#formclear').empty();
			$('#searchByAccount').empty();
			$('#searchByAccount').append(data);
	}) ;
}


function mylighthistory(){
	$.post(
			"${pageContext.request.contextPath}/ReservationsByCustomerServlet",
			{
				'userID': $('#userID').text()
			},
			function(data){
				$('#formclear').empty();
				$('#searchByAccount').empty();
				$('#aa').empty();
				$('#aa').append(data);
		}) ;
}

function checkNull()  
{  
	var regk=/(^[1-9]\d*$)/;
     var num=0;  
     var str="";  
     $("input.index-home").each(function(n){  
          if($(this).val()=="")  
          {  
               num++;  
               str+=$(this).attr("id")+"\r\r can't be empty!\n";  
          }  
     });  
     
     if(num>0)  
     {  
          alert(str);  
          return false;  
     }
     if(regk.test($("#adults").val())!=true){
    	 alert("Adults should be an integer!"); 
    	    return false;
    }
     if(regk.test($("#kids").val())!=true){
    	 alert("Kids should be an integer!"); 
    	    return false;
    }
    
      return true;  
   
} 
	
	</script>
	</body>
</html>
