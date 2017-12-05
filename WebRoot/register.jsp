<!doctype html>
<html>
<head>
<title>CDITS</title>
    	  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    	<link rel="stylesheet" type="text/css" href="./css/mystyle.css">
    	<script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
</head>
    
<body class="register">
    
<!-- Navigation Bar -->
<%@ include file="header.jsp"%>
<div class="content">
	<div class="container">
	<section id="content">
		<form action="registerServlet" method="post" accept-charset=utf-8 >
			<h1>Register Form</h1>
			<label>Email: </label>
		    <input class="index-home" type="text" name="email" id="email"> <span id="emailStatus"></span>
		    <br>
		    <label>First Name: </label>
		    <input class="index-home" type="text" name="firstname"  id="firstname">
		    <br><label>Last name: </label>
		    <input class="index-home" type="text" name="lastname" id="lastname">
		    <br>
		    <label>Address: </label>
		    <input class="index-home" size="100" type="text" name="address" id="address">
		    <br>
		    <label>City: </label>
		    <input class="index-home" type="text" name="city" id="city">
		    <br>
		    <label>State: </label>
		    <input class="index-home" type="text" name="state" id="state">
		    <br>
		    <label>ZipCode: </label>
		    <input class="index-home" type="text" name="zipcode" id="zipcode" size="5" maxlength="5">
		    <br>
		    <label>Password: </label>
		    <input class="index-home" type="text" name="password" id="password">
		
			<div>
				<input id="sub" class="search" type="submit" value="Register" onclick="return checkNull()"/>
			</div>
		</form><!-- form -->
		<div class="button">
		</div><!-- button -->
	</section><!-- content -->
  
</div></div>
	<script type="text/javascript">
	function checkNull()  
	{  
	     var num=0;  
	     var str="";  
	     $("input[type$='text']").each(function(n){  
	          if($(this).val()=="")  
	          {  
	               num++;  
	               str+=$(this).attr("id")+"\r\r can't be empty!\n";  
	          }  
	     });  
	     if(num>0)  
	     {  
	          alert(str);  
	          return false;  
	     }  
	     else  
	     {  
	          return true;  
	     }  
	}  
		$("#email").blur(function(){
			if($("#email").val()==null){
				$("#emailStatus").text("x");
    			$("#emailStatus").css({'color':'red'});
    			$("#sub").attr({'onclick':'return false'});
				return ;
			}else{
	        $.post(
	        	"${pageContext.request.contextPath}/checkEmailServlet",
	        	{
	        		"email":$("#email").val()
	        	},
	        	function(data){
	        		/* $("#emailStatus").innerHTML="" */
	        		var flag = data;
	        		if(flag=="false"){
	        			$("#emailStatus").text("x");
	        			$("#emailStatus").css({'color':'red'});
	        			$("#sub").attr({'onclick':'return false'});
	        		}else{
	        			$("#emailStatus").text("v");
	        			$("#emailStatus").css({'color':'green'});
	        			 $("#sub").attr({'onclick':'return checkNull()'}); 
	        		}
	        	}
	       	 )
			} 
	    });
	
	</script>
    
</body>
</html>