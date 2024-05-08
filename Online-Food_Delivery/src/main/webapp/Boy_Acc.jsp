<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>
<style type="text/css">
<%@
include
file="/css/feedback.css"
%>
</style>
</head>
<body style="background: pink !important;">
	<div class="contact-form">
	<form action="RestoDeliveryBoy" method="post">
		<h1>Jobs With Us</h1>
		<div class="txtb">
			<label>full name</label> <input type="text" name="name" 
				placeholder="Enter your name">
		</div>
		<div class="txtb">
			<label>Phone Number</label> <input type="text" name="phno" 
				placeholder="Enter your phone Number" maxlength="10">
		</div>
		<div class="txtb">
			<label>Email</label> <input type="email" name="email" 
				placeholder="Enter your email">

		</div>
		<div class="txtb">
			<label>Location(city)</label> <input type="text" name="address" 
				placeholder="Enter your Location">
		</div>
		<div class="txtb">
			<label>Create Password(min lenth 5)</label> <input type="text" name="pass" 
				placeholder="Enter your password" >
		</div>

		<div class="container-flex">
			<button class="btn btn-success" name="sub">Submit</button>
			<a class="btn btn-success" href="restorunt.jsp">Home</a>

		</div>
		</form>
	</div>
</body>
</html>