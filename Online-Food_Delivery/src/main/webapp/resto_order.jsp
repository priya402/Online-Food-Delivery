<%@page import="com.food.DataBase.DeliveryBoyDB"%>
<%@page import="com.food.Entity.DeliveryBoy"%>
<%@page import="com.food.Entity.User"%>
<%@page import="com.food.Entity.MenuItem"%>
<%@page import="com.food.DataBase.RestoruntMenu"%>
<%@page import="com.food.DataBase.RestoruntDbOperation"%>
<%@page import="com.food.DataBase.UserDbOperation"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.food.Entity.Orders"%>
<%@page import="java.util.List"%>
<%@page import="com.food.DataBase.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
<style type="text/css">
img {
	width: 100px;
	object-fit: contain;
	height: 100%;
}
</style>
</head>
<body>

	<%@ include file="resto_menu.jsp"%>
	<%
	Order odr = new Order();
	List<Orders> order = odr.getOrder();
	LocalDate date = LocalDate.now();

	UserDbOperation udb = new UserDbOperation();
	RestoruntMenu menu = new RestoruntMenu();
	List<MenuItem> mitm = menu.getAllMenu();
	List<User> user = udb.getAll();
	int rid = (int) session.getAttribute("rid");
	
	DeliveryBoyDB db = new DeliveryBoyDB();
	List<DeliveryBoy> boy = db.getall();
	if(order!=null){
	%>
	<section class="container-flex mt-2  mx-auto">
		<h1 class="ms-2 mb-4"
			style="font-family: sans-serif; font-style: italic;">Todays
			Orders</h1>

		<div class="container  table-responsive">
			<table id="cart"
				class="table table-hover border table-condensed container">
				<thead>
					<tr>
						<th style="width: 20%">Product</th>
						<th style="width: 20%">Item Name</th>
						<th style="width: 20%">Customer Name</th>
						<th style="width: 40%; height: 30%">Operation</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Orders odrr : order) {
						for (MenuItem mit : mitm) {
							for (User usr : user) {
						if ((odrr.getCid().equals(usr.getMno()) && odrr.getMid() == mit.getId() && odrr.getRid() == rid&& odrr.getStatus()!="rdeliver" )) {
					%>
					<tr>
						<td data-th="Product">
							<div class="row ">
								<div class="col-sm-2 hidden-xs">
									<img src="./images/<%=mit.getImage()%>" alt="..."
										class="img-responsive rounded mx-auto d-block" />
								</div>
							</div>
						</td>
						<td data-th="price"><%=mit.getName()%></td>
						<td data-th="Price"><%=usr.getUname()%></td>


						<td class="actions " data-th="">
							<form action="RestoruntOrders">
								<a class="btn btn-danger btn-sm mb-3"
									href="RestoruntOrders?astatus=<%=mit.getId()%>"> <i
									class="fa-solid fa-arrows-rotate"> Reject</i>
								</a>
								<button type="submit"
									class="btn btn-success btn-sm ms-lg-3 mb-3" name="assign">
									Assign to
								</button>
								<input type="hidden" name="mid" value="<%=mit.getId()%>">
								<select name="boy" >
									<%
									for (DeliveryBoy b : boy) {
									%>
									<option value="<%=b.getId()%>"><%=b.getName()%></option>
									<%
									}
									%>
								</select>
							</form>
						</td>

					</tr>

					<%
					}
					}
					}
					}
	
					%>
				</tbody>

			</table>
		</div>
	</section>
	<%} %>
</body>
</html>