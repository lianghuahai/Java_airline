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
	    		airlineName:	${flightInfo.airlineName}
	    		flightNo:	${flightInfo.flightNo}
	    		noOfSeats:	${flightInfo.noOfSeats}
	    		daysOperating:	${flightInfo.daysOperating}
	    		minLengthOfStay:	${flightInfo.minLengthOfStay}
	    		maxLengthOfStay:	${flightInfo.maxLengthOfStay}
	    		legNo:	${flightInfo.legNo}
	    		arriveTime:	${flightInfo.arriveTime}
	    		departTime:	${flightInfo.departTime}
	    		departAirport:	${flightInfo.departAirport}
	    		arriveAirport	${flightInfo.arriveAirport}<br>
	   </c:forEach>
</body>

<script type="text/javascript">




</script>
</html>