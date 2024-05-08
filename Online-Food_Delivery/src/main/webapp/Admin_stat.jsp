<%@page import="com.food.Entity.Feedback"%>
<%@page import="java.util.List"%>
<%@page import="com.food.DataBase.FeedBackDB"%>
<%@page import="com.food.DataBase.DeliveryBoyDB"%>
<%@page import="com.food.DataBase.UserDbOperation"%>
<%@page import="com.food.DataBase.RestoruntDbOperation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body style="background-color: pink !important;">
	<%@ include file="admin_nav.jsp"%>
	<%
	RestoruntDbOperation db = new RestoruntDbOperation();
	int resto = db.RestoCount();

	UserDbOperation db1 = new UserDbOperation();
	int user = db1.UserCount();

	DeliveryBoyDB db2 = new DeliveryBoyDB();
	int boy = db2.BoyCount();
	%>
	<section class="container  mt-3 mb-5">
		<div class="row row-cols-1 row-cols-md-3 g-5 py-5 px-5 d-flex">
			<div class="col text-center">
				<div class="card" style="width: 18rem; height: 18vh;">
					<h5 class="card-title mt-3">User's</h5>

					<div class="card-body">
						<h3 class="card-text"><%=user%>
							User's
						</h3>
					</div>
				</div>
			</div>

			<div class="col text-center">
				<div class="card" style="width: 18rem; height: 18vh;">
					<h5 class="card-title mt-3">Restorunt's</h5>

					<div class="card-body">
						<h3 class="card-text"><%=resto%>
							restorunt's
						</h3>
					</div>
				</div>
			</div>

			<div class="col text-center">
				<div class="card" style="width: 18rem; height: 18vh;">
					<h5 class="card-title mt-3">Delivery person</h5>

					<div class="card-body">
						<h3 class="card-text"><%=boy%>
							Boy's
						</h3>
					</div>
				</div>
			</div>
		</div>

	</section>

	<section class="container-flex mt-2  mx-auto mt-4">
		<h1 class="text-center mb-3">User FeedBacks</h1>
<%FeedBackDB db3=new FeedBackDB();
List<Feedback> feed=db3.getFeedback();

%>
		<div class="container table-responsive">

			<table id="cart"
				class="table table-hover border table-condensed container"
				style="background: fuchsia !important;">
				<thead>
					<tr>
						<th style="width: 20%">Name</th>
						<th style="width: 20%">Email</th>
						<th style="width: 20%">Phone</th>
						<th style="width: 30%">Feedback</th>
					</tr>
				</thead>
				<tbody>
				<%if(feed!=null)
					{
					for(Feedback f:feed){%>
				<tr>
						
						<td data-th="Price"><%=f.getName() %></td>
						<td data-th="Price"><%=f.getEmail() %></td>
						<td data-th="Price"><%=f.getPhno() %></td>
						<td data-th="Price"><%=f.getFeedback() %></td>
						</tr>
						<%}
					} %>
				</tbody>
			</table>
		</div>
	</section>
	<!-- 	Graph -->

</body>
</html>