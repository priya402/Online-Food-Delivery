<!DOCTYPE html>
<%@page import="com.food.DataBase.RestoruntMenu"%>
<%@page import="com.food.Entity.MenuItem"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	<c:if test="${login ne 'log'}">
		<c:redirect url="resto_login.jsp"></c:redirect>
	</c:if>
	<section class="mt-5 container mx-auto row mb-5">

		<h2>
			Do you want Update
			<%
		int mid = Integer.parseInt(request.getParameter("uid"));
		int urid=Integer.parseInt(request.getParameter("urid"));
		%>
		</h2>
		<%
		RestoruntMenu db = new RestoruntMenu();
		MenuItem menu = db.getMenu(mid);
		session.setAttribute("uid", mid);
		session.setAttribute("urid", urid);
		%>
		<form action="restorunt" method="post" enctype="multipart/form-data">
			<fieldset>
				<div class="form-group">
					<label for="disabledTextInput">Enter Name</label> <input
						type="text" id="disabledTextInput" class="form-control"
						placeholder="Name" name="Updatename" value="<%=menu.getName()%>">
				</div>
				<div class="form-group">
					<label for="disabledTextInput">Enter Price</label> <input
						type="text" id="disabledTextInput" class="form-control"
						placeholder="Price" name="Updateprice"
						value="<%=menu.getPrice()%>">
				</div>
				<div class="form-group">
					<label for="disabledTextInput">Enter Discount</label> <input
						type="text" id="disabledTextInput" class="form-control"
						placeholder="UpdateDiscount" value="<%=menu.getDiscount()%>"
						name="updatediscount">
				</div>
				<div class="form-group">
					<label for="disabledTextInput">Enter Type
						(veg,nonveg,sweet)</label> <input type="text" id="disabledTextInput"
						class="form-control" placeholder="type"
						value="<%=menu.getType()%>" name="updatetype">
				</div>
				<div class="form-group">
					<label for="disabledTextInput">Enter Description</label> <input
						type="text" id="disabledTextInput" class="form-control"
						placeholder="Description" value="<%=menu.getDescription()%>"
						name="updateDesc">
				</div>



			</fieldset>
			<div class="modal-footer d-flex">
				<a type="button" class="btn btn-secondary" href="restorunt.jsp">Close</a>
				<button type="submit" class="btn btn-primary" name="update">
					Update</button>
			</div>
		</form>


	</section>

</body>

</html>