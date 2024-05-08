<!DOCTYPE html>
<%@page import="com.food.Entity.DeliveryBoy"%>
<%@page import="com.food.DataBase.DeliveryBoyDB"%>
<%@page import="com.food.DataBase.RestoruntMenu"%>
<%@page import="com.food.Entity.MenuItem"%>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>
<style type="text/css">
<%@
include
file="/css/login.css"
%>
</style>
</head>
<body style="background: pink !important;">
	<%@ include file="AllLinks.jsp"%>
	<section class="mt-5 container mx-auto row mb-5">

		<h2>
			Do you want Update
			<%
		int mid =Integer.parseInt(request.getParameter("uboy"));
			DeliveryBoyDB db=new DeliveryBoyDB();
			DeliveryBoy boy=db.getBoy(mid);
			session.setAttribute("uboy", mid);
		%>
		</h2>
		<form action="AdminDelivery" method="post">

						<fieldset>
							<div class="form-group">
								<label for="disabledTextInput">Enter Name</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Name" name="name" value="<%=boy.getName()%>">
							</div>
							<div class="form-group">
								<label for="disabledTextInput">Enter Ph.no</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Phone No" name="Phno" value="<%=boy.getPhno()%>">
							</div>
							<div class="form-group">
								<label for="disabledTextInput">Enter Email</label> <input
									type="email" id="disabledTextInput" class="form-control"
									placeholder="Email" name="email" value="<%=boy.getEmail()%>">
							</div>

							<div class="form-group">
								<label for="disabledTextInput">Enter address</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Address" name="address" value="<%=boy.getAddress()%>">
							</div>
							<div class="form-group">
								<label for="disabledTextInput">Enter New Password</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Password" name="pass" value="<%=boy.getPass()%>">
							</div>
						

			</fieldset>
			<div class="modal-footer d-flex">
				<a type="button" class="btn btn-secondary" href="admin_DeliveryBoy.jsp">Close</a>
				<button type="submit" class="btn btn-primary" name="update">
					Update</button>
			</div>
		</form>


	</section>

</body>

</html>