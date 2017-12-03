<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  <body class="register">
	 <%@ include file="header.jsp"%>  
	 
	  <%--<h1><%=request.getAttribute("name")%></h1> <br>--%>
	  
	  <c:forEach var="item" items="${requestScope.airlineList}">
     	 <h1>${item.name}</h1> <br>
	  </c:forEach> 	
  </body>
</html>
