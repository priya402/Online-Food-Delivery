<%@page import="com.food.Entity.DeliveryBoy"%>
<%@page import="com.food.DataBase.DeliveryBoyDB"%>
<%@page import="javax.swing.plaf.basic.BasicMenuUI"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.food.DataBase.RestoruntMenu"%>
<%@page import="com.food.DataBase.RestoruntDbOperation"%>
<%@page import="com.food.Entity.MenuItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
img {
	width: 100px;
	object-fit: contain;
	height: 90%;
}
</style>
</head>
<body>
<c:if test="${log ne 'log'}">
		<c:redirect url="Admin.jsp"></c:redirect>
	</c:if>
	<%@ include file="admin_nav.jsp"%>
	<%
	DeliveryBoyDB db=new DeliveryBoyDB();
	List<DeliveryBoy> boy=db.getall();
	%>

	<section class="container-flex mt-2  mx-auto">
		<h1 class="text-center mb-3">Delivery Boy Information</h1>

		<div class="container table-responsive">

			<table id="cart"
				class="table table-hover border table-condensed container"
				style="background: fuchsia !important;">
				<thead>
					<tr>
						<th style="width: 10%">Name</th>
						<th style="width: 10%">Email</th>
						<th style="width: 10%">Phone No</th>
						<th style="width: 10%">Address</th>
						<th style="width: 10%">Pass</th>

						<th style="width: 20%" colspan="1">Operation
							<button class="btn btn-success btn-block ms-4"
								data-bs-toggle="modal" data-bs-target="#insert">Add New
							</button>
						</th>
					</tr>
				</thead>
				<tbody>
		<%
		if(boy!=null){
		for(DeliveryBoy b:boy) {%>
					
					<tr>
						<td data-th="Price"><%=b.getName() %></td>
						<td data-th="Price"><%=b.getEmail() %></td>

						<td data-th="Price"><%=b.getPhno() %></td>
						<td data-th="Price"><%=b.getAddress() %></td>
						<td data-th="Price"><%=b.getPass() %></td>

						<td class="actions " data-th=""><a
							class="btn btn-danger btn-sm mt-2"
							href="AdminDelivery?uboy=<%=b.getId() %>">
								<i class="fa-solid fa-arrows-rotate"> Update</i>
						</a>
						 <a class="btn btn-danger btn-sm mt-2 "
							href="AdminDelivery?dboy=<%=b.getId()%>">
								<i class="fa-solid fa-trash"> Delete</i>
						</a></td>
					</tr>
<%} 
}%>
				</tbody>

			</table>

		</div>
	</section>
	<!-- Modal Update  start-->

	<!-- 	 	model update end -->

	<!-- model insert start -->
	<div class="modal" id="insert" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Delivery Boy
						Information</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<form action="AdminDelivery" method="post">

						<fieldset>
							<div class="form-group">
								<label for="disabledTextInput">Enter Name</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Name" name="name">
							</div>
							<div class="form-group">
								<label for="disabledTextInput">Enter Ph.no</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Phone No" name="phno" maxlength="10">
							</div>
							<div class="form-group">
								<label for="disabledTextInput">Enter Email</label> <input
									type="email" id="disabledTextInput" class="form-control"
									placeholder="Email" name="email" >
							</div>

							<div class="form-group">
								<label for="disabledTextInput">Enter address</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Address" name="address">
							</div>
							<div class="form-group">
								<label for="disabledTextInput">Enter password</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Password" name="pass">
							</div>



						</fieldset>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" name="addBoy">add
								New</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>


	<!-- 	model insert end -->

</body>
</html>