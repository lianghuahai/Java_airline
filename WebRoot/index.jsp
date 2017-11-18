<!doctype html>
<html>
<head>
<title>CDITS</title>
     <link rel="stylesheet" type="text/css" href="./css/mystyle.css"> 
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>

</style>
</head>
    
<body class="register">
    
<!-- Navigation Bar -->
<div class="navbar">
  <a href="index.jsp" class="selected">CDITS</a>
  <a href="#" >My Reservations</a>
  <a href="#" >My Flight History</a>
  <a href="#" >Contact Support</a>
  <a href="login.jsp">Sign in</a>
  <a href="register.jsp">Register</a>
</div>
<hr>
<!-- Page content -->
<div class="content">

    <h2 >Search your flight</h2>
  
  <div class="search">
  <form action="">
    <div id="date">
      <label> From: </label>
      <input class="in" type="date" placeholder="DD MM YYYY">

      <label> To: </label>
      <input class="in" type="date" placeholder="DD MM YYYY">
    </div>
    <div id="location">
      <label> Departure City: </label>
      <input class="in" type="text" placeholder="Departure City">
  
      <label> Arrival City: </label>
      <input class="in" type="text" placeholder="Arrival City">
    </div>
    <div id="passenger">
      <label> Adults </label>
      <input class="in" type="text" placeholder="1" maxlength="3" >
 
      <label> Kids </label>
      <input class="in" type="text" placeholder="0" maxlength="3" >
    </div>
    <div id="class">
      <label> Class </label>
      <input class="in" type="text" placeholder="Economy">
      
    </div>
      <br>
      <button class="btn">Search</button>
       </form>
    
  </div>
 
</div>
    
    
</body>
</html>