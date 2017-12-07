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
	   		    <a href="allFlights.jsp" id="list of allFlights">list of allFlights</a>
	   		    <a href="javascript:void(0)" id="list of reservations">list of reservations</a>
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
		 		<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
	 
	  <a href="helpMenu.jsp" class="help-m">Help Menu</a>
	</div >
		<div id="date">
	      <label> Airline Name: </label>
	      <input class="index-home" type="text"  name="airportName" id="airportName">

	    </div>
	    <a href="javascript:void(0)" onclick="seachSeats()">SearchCustomerReseved:</a>
	    <div id="SearchByFlght">
	     f.setAirlineName(rs.getString("Name"));
                f.setNoOfSeats(rs.getInt("NoOfSeats"));
                f.setDaysOperating(rs.getString("DaysOperating"));
                f.setMinLengthOfStay(rs.getInt("MinLengthOfStay"));
                f.setMaxLengthOfStay(rs.getInt("MaxLengthOfStay"));
                f.setLegNo(rs.getInt("LegNo"));
                f.setArriveTime(rs.getTimestamp("ArrTime").toString());
                f.setDepartTime(rs.getTimestamp("DepTime").toString());
                f.setArriveAirport(rs.getString("ArriveAP"));
                f.setDepartAirport(rs.getString("DepartAP"));
	    	<c:forEach var="flightInfo" items="${FlightByGivenAirport}">
			    	<label>	${flightInfo.flightNo}</label>
			    	<label>	${flightInfo.noOfSeats}</label>
			    	<label>	${flightInfo.minLengthOfStay}</label>
			    	<label>	${flightInfo.daysOperating}</label>
			    	<label>	${flightInfo.legNo}</label>
			    	<label>	${flightInfo.arriveTime}</label>
			    	<label>	${flightInfo.departTime}</label>
			    	<label>	${flightInfo.arriveAirport}</label>
			    	<label>	${flightInfo.departAirport}</label>
	    			<br>
	    		</c:forEach>
	    </div>

<script type="text/javascript">
function seachSeats(){
	$("#aa").load(
		"${pageContext.request.contextPath}/flightByGivenAirport",
		{
			'airportName':$('#airportName').val()
		},
		function(data){
	}) ;
}



</script>
</body>
</html>