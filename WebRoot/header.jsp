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
  
	 <!-- Navigation Bar -->
	<div class="mystyle-navbar">
	  <a href="index.jsp" class="selected" id="index">Home</a>
	  
	  
	  
	  <c:if test="${not empty existUser}">
		  	<c:if test="${ existUser.level =='customer'}">
		  	<a href="#"  id="index">Cars</a>
			  <a href="#"  id="index">Hotels</a>
				  	<a href="#" >My Reservations</a>
				  <a href="autions.jsp" id="autions">Autions</a>
				  <a href="#" >My Flight History</a>
				  <a href="#" >Contact Support</a>
	   		  	<a href="register.jsp" id="register">Register</a>
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
			 	<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
		 	</c:if>
		 	
		  	<c:if test="${ existUser.level =='manager'}">
	   		    <a href="registerEmploye.jsp" id="employee" >employee</a>
	   		    <a href="javascript:void(0)" id="monthlyReport" onclick="mothlyReport()">monthlyReport</a>
	   		    <a href="javascript:void(0)" id="list of allFlights">list of allFlights</a>
	   		    <a href="javascript:void(0)" id="list of reservations">list of reservations</a>
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
		 		<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
			 		
		 	</c:if>
		 	
		  	<c:if test="${ existUser.level =='employee'}">
	   		    <a href="register.jsp" id="register">Record a reservation</a>
	   		    <a href="register.jsp" id="register">manage customer</a>
	   		    <a href="register.jsp" id="register">mailing list</a>
	   		    <a href="register.jsp" id="register">flight suggestions for a given customer</a>
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
		 		<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
		 	</c:if>
	  </c:if>
	  <c:if test="${empty existUser}">
			<a href="#"  id="index">Cars</a>
		    <a href="#"  id="index">Hotels</a>
		    <a href="#" >Contact Support</a>
		    <a href="register.jsp" id="register">Register</a>
		 	<a href="login.jsp" id="login">Sign in</a>
	  </c:if>
	  <a href="helpMenu.jsp" class="help-m">Help Menu</a>
	</div>
	
	
</html>
