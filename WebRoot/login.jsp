<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/mystyle.css">
 <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
</head>
<h2  id="login_status">${login_status}</h2>
<body class="login">
   <div class="container" >
	<div id="content">
		<form action="${pageContext.request.contextPath}/loginServlet" method="post" accept-charset=utf-8>
			<h1>Login Form</h1>
			<div>
				<input type="text" name="email" />
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