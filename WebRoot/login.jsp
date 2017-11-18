<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/mystyle.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>

<body class="login">
   <div class="container">
	<div id="content">
		<form action="loginServlet">
			<h1>Login Form</h1>
			<div>
				<input type="text" name="username" />
			</div>
			<div>
				<input type="password" name="password" />
			</div>
			<div>
				<input type="submit" value="Log in" />
				<a href="#">Lost your password?</a>
				<a href="register.jsp">Register</a>
			</div>
		</form><!-- form -->
		<div class="button">
		</div><!-- button -->
	</div><!-- content -->
</div><!-- container -->


</body>
</html>