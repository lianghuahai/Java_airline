<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./css/mystyle.css"> 
    <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
</head>
  
	 <!-- Navigation Bar -->
	<div class="mystyle-navbar">
	  <a href="index.jsp" class="selected" id="index">Home</a>
	  <a href="#"  id="index">Cars</a>
	  <a href="#"  id="index">Hotels</a>
	  
	  
	  <c:if test="${not empty existUser}">
		  	<c:if test="${ existUser.level =='customer'}">
				  	<a href="#" >My Reservations</a>
				  <a href="autions.jsp" id="autions">Autions</a>
				  <a href="#" >My Flight History</a>
				  <a href="#" >Contact Support</a>
	   		  	<a href="register.jsp" id="register">Register</a>
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
			 	<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
		 	</c:if>
		 	
		  	<c:if test="${ existUser.level =='manager'}">
	   		    <a href="registerEmploye.jsp" id="register">Register</a>
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
		 		<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
		 	</c:if>
		 	
		  	<c:if test="${ existUser.level =='employee'}">
	   		    <a href="register.jsp" id="register">Register</a>
	  			<span id="loginStatus">welcome ${existUser.firstname }</span>
		 		<a href="${pageContext.request.contextPath}/logoutServlet" id="logout">Log out</a>
		 	</c:if>
	  </c:if>
	  <c:if test="${empty existUser}">

	  <a href="#" >Contact Support</a>
	  <a href="register.jsp" id="register">Register</a>
	 	<a href="login.jsp" id="login">Sign in</a>
	  </c:if>
	  <a href="helpMenu.jsp" class="help-m">Help Menu</a>
	</div>
	
	
</html>
