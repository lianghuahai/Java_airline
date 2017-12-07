<!doctype html>
<html>
<head>
<title>CDITS</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
     <link rel="stylesheet" type="text/css" href="./css/mystyle.css"> 
     <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<!-- 	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.13.0/popper.min.js"></script>
 -->	  <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
</head>
<body class="register">

 <%@ include file="header.jsp"%>
<div class="row">
        <div class="col-md-4">
		<!--left pane Search  -->
			<div class="content">
			    <h2 >Search your flight</h2>
			    <form action="searchFlightServlet" method="post" accept-charset=utf-8>
			  <div class="search">
			    <div id="date" >
			      <label> From: </label>
			      <input class="index-home" type="date" placeholder="DD MM YYYY" name="departDate" id="departDate" value="${flight.departDate}">
			
			      <label> To: </label>
			      <input class="index-home" type="date" placeholder="DD MM YYYY" name="returnDate" id="returnDate" value="${flight.returnDate}">
			    </div>
			    <div id="location">
			      <label> Departure City: </label>
			      <input class="index-home" type="text" placeholder="Departure City" name="departCity" id="departCity" value="${flight.departCity}">
			  
			      <label> Arrival City: </label>
			      <input  class="index-home" type="text" placeholder="Arrival City" name="arriveCity" id="arriveCity" value="${flight.arriveCity}">
			    </div>
			    <div id="passenger">
			      <label> Adults </label>
			      <input class="index-home" type="text"  maxlength="3" name="adults" id="adults" value="${flight.adults}">
			 
			      <label> Kids </label>
			      <input class="index-home" type="text" maxlength="3" name="kids" id="kids" value="${flight.kids}">
			    </div>
			      <label> Class </label>
			      <!-- <input class="in" type="text" placeholder="Economy" name="classLevel" id="classLevel"> -->
					    <select class="index-home"  name="classLevel" id="classLevel">
						  <option class="index-home" value="economy" <c:if test="${'economy' eq flight.classLevel}">selected</c:if> id="economy">Economy</option>
						  <option class="index-home" value="bussiness" <c:if test="${'bussiness' eq flight.classLevel}">selected</c:if> id="bussiness">Bussiness</option>
						  <option class="index-home" value="first" <c:if test="${'first' eq flight.classLevel}">selected</c:if> id="first">First</option>
						</select>
			    <label> Preferred airline </label>
			              <select class="index-home"  name="preferAirline" id="preferAirline">
			                <option value="nop" <c:if test="${'nop' eq flight.preferAirline}">selected</c:if>> No preference</option>
			              	<option value="Air Berlin" <c:if test="${'Air Berlin' eq flight.preferAirline}">selected</c:if>>Air Berlin</option>
			              	<option value="United Airlines" <c:if test="${'United Airlines' eq flight.preferAirline}">selected</c:if>>United Airlines</option>
			              	<option value="Air Japan" <c:if test="${'Air Japan' eq flight.preferAirline}">selected</c:if>>Air Japan</option>
			              	<option value="Air Madagascar" <c:if test="${'Air Madagascar' eq flight.preferAirline}">selected</c:if>>Air Madagascar</option>
			              	<option value="American Airlines" <c:if test="${'American Airlines' eq flight.preferAirline}">selected</c:if>>American Airlines</option>
			              	<option value="British Airways" <c:if test="${'British Airways' eq flight.preferAirline}">selected</c:if>>British Airways</option>
			              	<option value="Delta Airlines" <c:if test="${'Delta Airlines' eq flight.preferAirline}">selected</c:if>>Delta Airlines</option>
			              	<option value="JetBlue Airways" <c:if test="${'JetBlue Airways' eq flight.preferAirline}">selected</c:if>>JetBlue Airways</option>
			              	<option value="Lufthansa" <c:if test="${'Lufthansa' eq flight.preferAirline}">selected</c:if>>Lufthansa</option>
			              	<option value="Southwest Airlines" <c:if test="${'Southwest Airlines' eq flight.preferAirline}">selected</c:if>>Southwest Airlines</option>
			              </select>
			         
			      <br>
			      <button class="btn-m"  type="submit">Search</button>
			      </form>
			  </div>
			</div>
		</div>
		
		<c:if test="${not empty resultList}">
		<div class="col-md-6">
			<!--show search result here  -->
			 <h2 >Search Result:</h2>
			<c:forEach var="flightInfo" items="${requestScope.resultList}">
				<div class="result-content">
				 	<div class="single-result" id="single-result">
					 	<div class="flight-div-time">
					 	<div id="label-style-stop">
					 	<span>Stop:${flightInfo.stop}</span>
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
	  <c:if test="${empty resultList}">
	 	<h3 >No Such Result,Please Search Again!</h3>
	  </c:if>
		
		
		
		
		
		
</div>
	
<script type="text/javascript">
	function submitForm(){
		$.post(
	        	"${pageContext.request.contextPath}/searchInDetails",
	        	{
	        		"departDate":$("#departDate").val(),
	        		"returnDate":$("#returnDate").val(),
	        		"departCity":$("#departCity").val(),
	        		"arriveCity":$("#arriveCity").val(),
	        		"adults":$("#adults").val(),
	        		"kids":$("#kids").val(),
	        		"classLevel":$("#classLevel").val(),
	        		"":$("#").val(),
	        		"":$("#").val(),
	        		"":$("#").val(),
	        		"":$("#").val()
	        	},
	        	function(data){
	        	}
	       	 )
		
		
	}

















	function checkNull()  
		{  
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
		     else  
		     {  
		    	 alert(1);
		          return true;  
		     }  
		}  







</script>>
    
</body>
</html>