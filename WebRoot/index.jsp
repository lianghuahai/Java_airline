<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <base href="<%=basePath%>">
    
    <title> Chicken Dinner In The Sky</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	 <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="js/jquery-1.8.3.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="js/bootstrap.min.js"></script> 
	
  </head>
  
 <body>

<div class="container-fluid">


<nav class="nav nav-tabs" id="myTab" role="tablist" >
  <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Home</a>
  <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Profile</a>
  <a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Contact</a>
</nav>
<div class="tab-content" id="nav-tabContent">
  <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab"><br/></div>
  <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">...</div>
  <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">...</div>
</div>

	<div>

  
    Origin：<input type="text" id="ori"/>	
	Destination：<input type="text" id="des"/><br/>
	Departing：<input type="text" id="des"/>
	Returning：<input type="text" id="des"/><br/>
    
    
    
    <button type="submit" class="btn-primary btn-action gcw-submit" id="search-button-hp-package">
          <span class="btn-label">Search</span>
        </button>
        
        
        
        </div>
</div>
<%--
   
   <nav class="navbar navbar-dark bg-dark">
  <!-- Navbar content -->
</nav>

<nav class="navbar navbar-dark bg-primary">
  <!-- Navbar content -->
</nav>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
  <!-- Navbar content -->
</nav>
   	
   
   
   
  --%>
  
  <form action="/CDITK/loginServlet">
  username：<input type="text" name="username"/>	
  password：<input type="text" name="password"/>	
  
  <input type="submit" id="password"/>submit
  
  </form>
  
  
  
  
  
  
  
  
  
  
  
  
  </body>
</html>
