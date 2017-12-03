<!doctype html>
<html>
<head>
<title>CDITS</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
     <link rel="stylesheet" type="text/css" href="./css/mystyle.css"> 
     <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
	  <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
</head>
<body class="register">

 <%@ include file="header.jsp"%>
<div class="row">
        <div class="col-md-4">
		<!--left pane Search  -->
			<div class="content">
			    <h2 >Search your flight</h2>
			  <div class="search">
			  <form action="searchFlightServlet" method="post" accept-charset=utf-8>
			    <div id="date" >
			      <label> From: </label>
			      <input class="in" type="date" placeholder="DD MM YYYY" name="departDate" id="departDate" value="${flight.departDate}">
			
			      <label> To: </label>
			      <input class="in" type="date" placeholder="DD MM YYYY" name="returnDate" id="returnDate" value="${flight.returnDate}">
			    </div>
			    <div id="location">
			      <label> Departure City: </label>
			      <input class="in" type="text" placeholder="Departure City" name="departCity" id="departCity" value="${flight.departCity}">
			  
			      <label> Arrival City: </label>
			      <input  class="in" type="text" placeholder="Arrival City" name="arriveCity" id="arriveCity" value="${flight.arriveCity}">
			    </div>
			    <div id="passenger">
			      <label> Adults </label>
			      <input class="in" type="text"  maxlength="3" name="adults" id="adults" value="${flight.adults}">
			 
			      <label> Kids </label>
			      <input class="in" type="text" maxlength="3" name="kids" id="kids" value="${flight.kids}">
			    </div>
			    <div id="class">
			      <label> Class </label>
			      <!-- <input class="in" type="text" placeholder="Economy" name="classLevel" id="classLevel"> -->
					    <select class="in"  name="classLevel" id="classLevel">
						  <option class="in" value="economy" selected id="economy">Economy</option>
						  <option class="in" value="bussiness"  id="bussiness">Bussiness</option>
						  <option class="in" value="first"  id="first">First</option>
						</select>
			    </div>
			      <br>
			      <button class="btn" type="submit" onclick="return checkNull()">Search</button>
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
				 		<label class="flight-label">DepartTime:${flightInfo.departTime}</label>
				 		<label class="flight-label" id="label-style">ReturnTime:${flightInfo.returnTime}</label><br>
				 		<label class="flight-label">DepartAirport:${flightInfo.departAirport}</label>
				 		<label class="flight-label">ArriveAirport:${flightInfo.arriveAirport}</label>
				 		<label class="flight-label">Airline:${flightInfo.airline}</label>
				 		<label class="flight-label" id="label-style">Stop:${flightInfo.stop}</label>
				 		<label class="flight-label" id="label-style">TicketPrice:${flightInfo.ticketPrice}</label>
				 	</div>
				</div>
			</c:forEach>
		
           
        </div>
		<div class="col-md-1">
		<p><em>Stop:</em><p>
		<p>1stop</p>
		<p>2stop</p>
		<p><em>Airlines include</em><p>
		<p>UA</p>
		<p>AC</p>
		<p>VA</p>
		<p><em>Departure Time:</em><p>
		<p>11:00</p>
		<p>11:00</p>
		<p><em>Arrival Time:</em><p>
		<p>11:00</p>
		<p>11:00</p>
		<p>11:00</p>
		<p>11:00</p>
		
		</div>
	  </c:if>
	  <c:if test="${empty resultList}">
	 	<h3 >No Such Result,Please Search Again!</h3>
	  </c:if>
		
		
		
		
		
		
</div>
	
<script type="text/javascript">
function checkNull()  
{  
     var num=0;  
     var str="";  
     $("input.in").each(function(n){  
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
          return true;  
     }  
}  







</script>>
    
</body>
</html>