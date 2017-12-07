<!doctype html>
<html>
<head>
<title>CDITS</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
	  <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
     <link rel="stylesheet" type="text/css" href="./css/mystyle.css"> 

<style>
.dropdown-submenu {
    position: relative;
}

.dropdown-submenu .dropdown-menu {
    top: 0;
    left: 100%;
    margin-top: -1px;
}
</style>

</head>
<body class="register">

 
		<!--left pane Search  -->
			<div class="content">
			    <h2 >Search your flight</h2>
			  <div class="search">
			  <form action="SearchRoundTripServlet" method="post" accept-charset=utf-8>
			    <div id="date" >
			      <label> From: </label>
			      <input class="index-home" type="date" placeholder="DD MM YYYY" name="departDate" id="departDate">
			
			      <label> To: </label>
			      <input class="index-home" type="date" placeholder="DD MM YYYY" name="returnDate" id="returnDate">
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
			       </form>
			  </div>
			</div>
		<div></div>
		
	<c:if test="${not empty resultList}">
		<div class="col-md-6">
			<!--show search result here  -->
			 <h2 >Search Result:</h2>
			<c:forEach var="flightInfo" items="${requestScope.resultList}">
				<c:forEach var="flightInfoTwo" items="${requestScope.resultListTwo}">
				<div style="border-style: solid;">
						<div class="result-content">
					 		<div class="single-result" id="single-result">
						 	<div class="flight-div-time">
						 	<div id="label-style-stop">
						 	<span>Stop:${flightInfo.transferAirport}</span>
						 	</div>
						 		<label class="flight-label" >DepartTime: <span>${flightInfo.departTime}</span></label>
						 		<label class="flight-label" id="label-style">ReturnTime: <span>${flightInfo.returnTime}</span></label>
						 	</div>
						 	
						 	<div class="flight-div-city">
						 		<label class="flight-label">DepartAirport: ${flightInfo.departAirport}</label>
						 		<label class="flight-label" id="label-style">ArriveAirport: ${flightInfo.arriveAirport}</label>
						 	</div>
						 	<div class="flight-label-stopPrice">
						 		<label class="flight-label">Airline: ${flightInfo.airline}</label>
						 		<label class="flight-label" id="label-style">TicketPrice:$ ${flightInfo.ticketPrice}</label>
					 		</div>
					 		<div class="flight-div-time">
						 		<a href="#" id="selectFlight">Select</a>
						 	</div>
					 		</div>
						</div>
						
						<div class="result-content">
					 		<div class="single-result" id="single-result">
						 	<div class="flight-div-time">
						 	<div id="label-style-stop">
						 	<span>Stop:${flightInfoTwo.transferAirport}</span>
						 	</div>
						 		<label class="flight-label" >DepartTime: <span>${flightInfoTwo.departTime}</span></label>
						 		<label class="flight-label" id="label-style">ReturnTime: <span>${flightInfoTwo.returnTime}</span></label>
						 	</div>
						 	
						 	<div class="flight-div-city">
						 		<label class="flight-label">DepartAirport: ${flightInfoTwo.departAirport}</label>
						 		<label class="flight-label" id="label-style">ArriveAirport: ${flightInfoTwo.arriveAirport}</label>
						 	</div>
						 	<div class="flight-label-stopPrice">
						 		<label class="flight-label">Airline: ${flightInfoTwo.airline}</label>
						 		<label class="flight-label" id="label-style">TicketPrice:$ ${flightInfoTwo.ticketPrice}</label>
					 		</div>
					 		<div class="flight-div-time">
						 		<a href="#" id="selectFlight">Select</a>
						 	</div>
					 		</div>
						</div>
						</div>
				</c:forEach>
			</c:forEach>
		
           
        </div>
		<div class="col-md-2">
		
		<p><em>Stop:</em><p>
		<input type="checkbox" id="nonstop" name="nonstop">Nonstop<br>
		<input type="checkbox" id="onestop" name="onestop">1 stop<br>
		<input type="checkbox" id="twoMoreStop" name="twoMoreStop">2+stop<br>
		
		
		<p><em>Airlines included:</em><p>
		<c:forEach var="flightInfo" items="${requestScope.resultList}">
			<input type="checkbox" id="${flightInfo.airline}" name="${flightInfo.airline}" value="${flightInfo.airline}">${flightInfo.airline}<br>
		</c:forEach>
		
		
		<p><em>Departure Time:</em><p>
		<input type="checkbox" id="dpEarly" name="dpEarly">Early Morning(12:00a - 4:59a)<br>
		<input type="checkbox" id="dpMorning" name="dpMorning">Morning(5:00a - 11:59a) <br>
		<input type="checkbox" id="dpAfternoon" name="dpAfternoon">Afternoon(12:00p - 5:59p) <br>
		
		
		<p><em>Arrival Time:</em><p>
		<input type="checkbox" id="arAfternoon" name="arAfternoon">Afternoon(12:00p - 5:59p) <br>
		<input type="checkbox" id="arEvening" name="arEvening">Evening(6:00p - 11:59p)  <br>

		</div>
		
	  </c:if>
	  

    
    
 
<!-- Show result -->
<script type="text/javascript">
function submitForm(){
	alert("SearchRoundTripServlet")
	$.post(
        	"${pageContext.request.contextPath}/SearchRoundTripServlet",
        	{
        		"departDate":$("#departDate").val(),
        		"returnDate":$("#returnDate").val(),
        		"departCity":$("#departCity").val(),
        		"arriveCity":$("#arriveCity").val(),
        		"adults":$("#adults").val(),
        		"kids":$("#kids").val(),
        		"classLevel":$("#classLevel").val(),
        	},
        	function(data){
        	}
       	 )
	
	
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
</script>>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
</body>
</html>