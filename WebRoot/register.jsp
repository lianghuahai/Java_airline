<!doctype html>
<html>
<head>
<title>CDITS</title>
    	<link rel="stylesheet" type="text/css" href="./css/mystyle.css">
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
    
<body class="register">
    
<!-- Navigation Bar -->
<div class="navbar">
  <a href="index.jsp" >CDITS</a>
  <a href="#" id="selected">My Reservations</a>
  <a href="#" >My Flight History</a>
  <a href="#" >Contact Support</a>
  <a href="login.jsp" >Sign in</a>
  <a href="register.jsp"  class="selected">Register</a>
</div>

<!-- Page content -->
<hr>
<div class="content">
	<div class="container">
	<section id="content">
		<form action="registerServlet" method="post">
			<h1>Register Form</h1>
			<label>Email: </label>
		    <input class="in" type="text" name="email">
		    <br>
		    <label>First Name: </label>
		    <input class="in" type="text" name="firstname">
		    <label>Last name: </label>
		    <input class="in" type="text" name="lastname">
		    <br>
		    <label>Address: </label>
		    <input class="in" size="100" type="text" name="address">
		    <br>
		    <label>City: </label>
		    <input class="in" type="text" name="city">
		    <br>
		    <label>State: </label>
		    <input class="in" type="text" name="state">
		    <br>
		    <label>ZipCode: </label>
		    <input class="in" type="text" name="zipcode" size="5" maxlength="5">
		    <br>
		    <label>Password: </label>
		    <input class="in" type="text" name="password">
		
			<div>
				<input class="search" type="submit" value="Register" />
			</div>
		</form><!-- form -->
		<div class="button">
		</div><!-- button -->
	</section><!-- content -->
  
</div></div>

    
</body>
</html>