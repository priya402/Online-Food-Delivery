<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.food.Entity.MenuItem"%>
<%@page import="com.food.DataBase.RestoruntMenu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot</title>
</head>
<body>
	<%if(request.getParameter("buy")==null ){%>
			<c:redirect url="Accout.jsp"></c:redirect>
	<%} %>
	<%
	int buy = Integer.parseInt(request.getParameter("buy"));
	String uname = (String) session.getAttribute("uname");
	List<Integer> cart = (List<Integer>) session.getAttribute(uname + "cart");
	RestoruntMenu db = new RestoruntMenu();
	List<MenuItem> menu = db.getAllMenu();
	MenuItem itm;
	List<MenuItem> purchas=new ArrayList<>();
	%>
	
	<%@ include file="AllLinks.jsp"%>
	<section class="mt-5 container-flex  mx-auto row ">
		<div class="col-sm-auto  col-md-auto col-lg-3 mx-auto mt-5">
			<div class="card bg-white mt-5">
				<div class="card-body border border-light">
					<h1 class="text-center">BILLING</h1>
					<form action="Purchase" method="post">
						<div class="mb-3">
							<h4>Your items :</h4>
							<table id="cart" class="table table-hover table-condensed">
								<thead>
									<tr>
										<th style="width: 30%">Product Name</th>
										<th style="width: 30%">Product Price</th>
									</tr>
								</thead>
								<tbody>
									<%
									for (MenuItem mit : menu) {
										int c = mit.getId();
										if (cart.contains(c)) {
									%>
									<%
									int y = Integer.parseInt(mit.getPrice());
									int w = (int) y;
									int z = mit.getDiscount();
									double x = 0, k = 0;

									x = (w * z) / 100;
									k = w - x;
									%>
									<tr>
										<td data-th="Price"><%=mit.getName()%></td>
										<td data-th="Price"><%=k%> &#8377</td>

										<%
										
										itm=new MenuItem();
										itm.setId(mit.getId());
										itm.setName(mit.getName());
										itm.setPrice(String.valueOf(Math.round(k)));
										itm.setType(mit.getType());
										
										purchas.add(itm);
										}
										}
										%>
									</tr>
									<tr>
										<td data-th="Price" >Total Bill Pay</td>

										<td data-th="Price"><%=buy%> &#8377</td>
									<tr>
								</tbody>
							</table>
						</div>
							
						<%session.setAttribute("Order", purchas); %>
						<div class="container-flex text-center">
							<button type="submit" class="btn btn-primary ml-5" name="cancle">Cancle
							</button>
							<button type="submit" class="btn btn-primary ml-5"
								name="purchace" onclick="alert('Your Order Now Placed')">Purchace</button>
						</div>


					</form>
				</div>
			</div>
		</div>
	</section>

</body>
</html>