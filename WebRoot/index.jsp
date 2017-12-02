<!doctype html>
<html>
<head>
<title>CDITS</title>
     <link rel="stylesheet" type="text/css" href="./css/mystyle.css"> 
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body class="register">

 <%@ include file="header.jsp"%>
 
 <!-- Page content -->
	<div class="content">
	
	    <h2 >Search your flight</h2>
	  <div class="search">
	  <form action="searchFlight()" method="post">
	    <div id="date" >
	      <label> From: </label>
	      <input class="in" type="date" placeholder="DD MM YYYY" name="departDate">
	
	      <label> To: </label>
	      <input class="in" type="date" placeholder="DD MM YYYY" name="returnDate">
	    </div>
	    <div id="location">
	      <label> Departure City: </label>
	      <input class="in" type="text" placeholder="Departure City" name="departCity">
	  
	      <label> Arrival City: </label>
	      <input  class="in" type="text" placeholder="Arrival City" name="arriveCity">
	    </div>
	    <div id="passenger">
	      <label> Adults </label>
	      <input class="in" type="text" placeholder="1" maxlength="3" name="adults">
	 
	      <label> Kids </label>
	      <input class="in" type="text" placeholder="0" maxlength="3" name="kids">
	    </div>
	    <div id="class">
	      <label> Class </label>
	      <input class="in" type="text" placeholder="Economy" name="classLevel">
	    </div>
	      <br>
	      <button class="btn" type="submit">Search</button>
	       </form>
	  </div>
	</div>
	
<script type="text/javascript">
function searchFlight(){
	//airlineServlet
	
}
</script>>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
</body>
</html>