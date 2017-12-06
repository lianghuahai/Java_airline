<!doctype html>
<html>
<head>
<title>CDITS</title>
     <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
	  <script type="text/javascript" src="./js/jquery-1.8.3.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
	  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
     <link rel="stylesheet" type="text/css" href="./css/mystyle.css"> 
</head>
<body class="register">

 <%@ include file="header.jsp"%>
		<!--left pane Search  -->
			<div class="content">
			    <h2 >Search your flight</h2>
			  <div class="search">
			  <form action="searchFlightServlet" method="post" accept-charset=utf-8>
			    <div id="date" >
			      <label> From: </label>
			      <input class="index-home" type="date" placeholder="DD MM YYYY" name="departDate" id="departDate">
			
			      <label> To: </label>
			      <input class="index-home" type="date" placeholder="DD MM YYYY" name="returnDate" id="returnDate">
			    </div>
			    <div id="location">
			      <label> Departure City: </label>
			      <input class="index-home" type="text" placeholder="Departure City" name="departCity" id="departCity">
			  
			      <label> Arrival City: </label>
			      <input  class="index-home" type="text" placeholder="Arrival City" name="arriveCity" id="arriveCity">
			    </div>
			    <div id="passenger">
			      <label> Adults </label>
			      <input class="index-home" type="text"  maxlength="3" name="adults" id="adults" ">
			 
			      <label> Kids </label>
			      <input class="index-home" type="text" maxlength="3" name="kids" id="kids">
			    </div>
			      <label> Class </label>
			      <!-- <input class="in" type="text" placeholder="Economy" name="classLevel" id="classLevel"> -->
					    <select class="index-home"  name="classLevel" id="classLevel">
						  <option class="index-home" value="economy" selected id="economy">Economy</option>
						  <option class="index-home" value="bussiness"  id="bussiness">Bussiness</option>
						  <option class="index-home" value="first"  id="first">First</option>
						</select>
	    		<label> Preferred airline </label>
			              <select class="index-home"  name="preferAirline" id="preferAirline">
			                <option selected="selected" value=""> No preference</option>
			              	<option value="Air Berlin">Air Berlin</option>
			              	<option value="United Airlines">United Airlines</option>
			              	<option value="Air Japan">Air Japan</option>
			              	<option value="Air Madagascar">Air Madagascar</option>
			              	<option value="American Airlines">American Airlines</option>
			              	<option value="British Airways">British Airways</option>
			              	<option value="Delta Airlines">Delta Airlines</option>
			              	<option value="JetBlue Airways">JetBlue Airways</option>
			              	<option value="Lufthansa">Lufthansa</option>
			              	<option name="" value="Southwest Airlines">Southwest Airlines</option>
			              </select>
			      <br>
			      <button class="btn" type="submit" onclick="return checkNull()">Search</button>
			       </form>
			  </div>
			</div>
		
		


    
    
 
<!-- Show result -->
<script type="text/javascript">

function checkNull()  
{  
	var regk=/(^[1-9]\d*$)/;
     var num=0;  
     var str="";  
     $("input.index-home").each(function(n){  
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
     if(regk.test($("#adults").val())!=true){
    	 alert("Adults should be an integer!"); 
    	    return false;
    }
     if(regk.test($("#kids").val())!=true){
    	 alert("Kids should be an integer!"); 
    	    return false;
    }
    
      return true;  
   
}  
</script>>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
</body>
</html>