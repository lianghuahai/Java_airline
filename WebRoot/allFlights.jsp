<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/mystyle.css"> 
</head>
<body>
			

		<c:forEach var="flightInfo" items="${list}">
		<div class="result-content">
				 	<div class="single-result" id="single-result">
 		<label class="flight-label"><label class="word" id="xxx">airlineName:</label>	${flightInfo.airlineName}</label>
 		<label class="flight-label"><label class="word" id="xxx">noOfSeats:</label>	${flightInfo.noOfSeats}</label>
 		<label class="flight-label"><label class="word" id="xxx">daysOperating:</label>	${flightInfo.daysOperating}</label>
 		<label class="flight-label"><label class="word" id="xxx">minLengthOfStay:</label>	${flightInfo.minLengthOfStay}</label>
 		<label class="flight-label"><label class="word" id="xxx">maxLengthOfStay:</label>	${flightInfo.maxLengthOfStay}</label>
 		<label class="flight-label"><label class="word" id="xxx">legNo:</label>	${flightInfo.legNo}</label>
 		<label class="flight-label"><label class="word" id="xxx">arriveTime:</label>	${flightInfo.arriveTime}</label>
 		<label class="flight-label"><label class="word" id="xxx">departTime:</label>	${flightInfo.departTime}</label>
 		<label class="flight-label"><label class="word" id="xxx">departAirport:</label>	${flightInfo.departAirport}</label>
 		<label class="flight-label"><label class="word" id="xxx">arriveAirport:</label>	${flightInfo.arriveAirport}</label>
 		<label class="flight-label"><label class="word" id="xxx">flightNo:</label>	${flightInfo.flightNo}</label>
	    			<br>
	    		</div></div>
	   </c:forEach>
</body>

<script type="text/javascript">




</script>
</html>