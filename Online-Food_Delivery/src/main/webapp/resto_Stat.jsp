<%@page import="com.food.Entity.User"%>
<%@page import="com.food.DataBase.UserDbOperation"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.food.Entity.Orders"%>
<%@page import="com.food.DataBase.Order"%>
<%@page import="com.food.DataBase.DeliveryBoyDB"%>
<%@page import="com.food.Entity.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="com.food.DataBase.RestoruntMenu"%>
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
<body>

	<%@ include file="resto_menu.jsp"%>
	<%
	int rid = (int) session.getAttribute("rid");

	RestoruntMenu db = new RestoruntMenu();
	List<MenuItem> menu = db.getAllMenu();
	HttpSession sesion = request.getSession();
	//String rid=(String)session.getAttribute("rid");
	int count = 0;
	DeliveryBoyDB db2 = new DeliveryBoyDB();
	int boy = db2.BoyCount();
	%>
	<%
	for (MenuItem menuu : menu) {
		if (menuu.getResto_id() == rid) {
			count++;
		}
	}
	int orders=0;
	%>
	<%
	Order odr = new Order();
	List<Orders> order = odr.getOrder();
	LocalDate date = LocalDate.now();

	UserDbOperation udb = new UserDbOperation();
	RestoruntMenu menuu = new RestoruntMenu();
	List<MenuItem> mitm = menuu.getAllMenu();
	List<User> user = udb.getAll();
	int ridd = (int) session.getAttribute("rid");

	
	for (Orders odrr : order) {
		for (MenuItem mit : mitm) {
			for (User usr : user) {
		if ((odrr.getCid().equals(usr.getMno()) && odrr.getMid() == mit.getId() && odrr.getRid() == rid
				&& odrr.getStatus() != "deliver")) {
			orders++;
		}
			}
		}
	}
	%>


	<section class="container  mt-3 mb-5">
		<div class="row row-cols-1 row-cols-md-3 g-5 py-5 px-5 d-flex">
			<div class="col text-center">
				<div class="card" style="width: 18rem; height: 18vh;">
					<h3 class="card-title mt-4">Menu Items</h3>

					<div class="card-body">
						<h4 class="card-text"><%=count%>
							Items
						</h4>
					</div>
				</div>
			</div>

			<div class="col text-center">
				<div class="card" style="width: 18rem; height: 18vh;">
					<h3 class="card-title mt-4">Delivery Boy</h3>

					<div class="card-body">
						<h4 class="card-text"><%=boy%>
							persons
						</h4>
					</div>
				</div>
			</div>

			<div class="col text-center">
				<div class="card" style="width: 18rem; height: 18vh;">
					<h3 class="card-title mt-4">orders</h3>

					<div class="card-body">
						<h4 class="card-text"><%=orders%> Sells In month</h4>
					</div>
				</div>
			</div>
		</div>

	</section>


	<!-- 	Graph -->
	<section class="container mt-3">
		<div class="col-xs-12 text-center">
			<h2>Donut Chart</h2>
		</div>



	</section>
</body>
</html>