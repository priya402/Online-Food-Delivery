<%@page import="java.time.LocalDate"%>
<%@page import="com.food.Entity.Orders"%>
<%@page import="com.food.DataBase.Order"%>
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
<title>My Account</title>
<style type="text/css">
img {
	width: 100px;
	object-fit: contain;
	height: 90%;
}
</style>
</head>
<body style="background: pink !important;">
	<c:if test="${status ne 'log' }">
		<c:redirect url="login.jsp" />
	</c:if>
	<%@ include file="NavBar.jsp"%>

	<!-- 		User Details -->
	<%-- 	<% request.getSession().invalidate();%> --%>
	<h3 class="text-center">
		Welcome
		<%
	String uname = (String) session.getAttribute("uname");
		String cli=(String)session.getAttribute("cid");
	%><%=uname %>
		To Your Account
	</h3>
	<br>

	<!-- 		Cart Section -->
	<section class="container-flex mt-2  mx-auto">

		<%
		RestoruntMenu db = new RestoruntMenu();
		List<MenuItem> menu = db.getAllMenu();
		List<Integer> cart = (List<Integer>) session.getAttribute(uname + "cart");
		Order odr = new Order();
		List<Orders> order = odr.getOrder();
		LocalDate date = LocalDate.now();
		List<MenuItem> AllOrder = (List<MenuItem>) session.getAttribute("Order");
		int count = 0;
		%>
		<%
		if (cart == null) {
		%>
		<p>Cart is Empty</p>

		<%
		}
		%>


		<%
		if (cart != null) {
		%>
		<div class="container table-responsive">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 30%">Product</th>
						<th style="width: 10%">Name</th>
						<th style="width: 10%">Price</th>
						<th style="width: 10%">Discount</th>
						<th style="width: 10%">SubTotal</th>
						<th style="width: 20%">Action</th>
					</tr>
				</thead>
				<tbody>

					<%
					for (MenuItem mit : menu) {
						int c = mit.getId();
						if (cart.contains(c)) {
					%>

					<tr>
						<td data-th="Product">
							<div class="row">
								<div class="col-sm-2 hidden-xs">
									<img src="./images/<%=mit.getImage()%>" alt="..."
										class="img-responsive rounded mx-auto d-block" />
								</div>
							</div>
						</td>
						<td data-th="Price"><%=mit.getName()%></td>
						<td data-th="Price"><%=mit.getPrice()%></td>
						<td data-th="Price"><%=mit.getDiscount()%> %</td>
						<td data-th="Price">
							<%
							int y = Integer.parseInt(mit.getPrice());
							int w = (int) y;
							int z = mit.getDiscount();
							double x = 0, k = 0;

							x = (w * z) / 100;
							k = w - x;
							%> <%=k%>
						</td>


						<%
						//int j = Integer.parseInt(mit.getPrice());
						try {
							count += k;
						} catch (Exception e) {

						}
						%>

						<td class="actions" data-th="">
							<button type="submit" class="btn btn-danger btn-sm"
								onclick="location.reload()" name="refresh">
								<i class="fa-solid fa-arrows-rotate"></i>
							</button> <a class="btn btn-danger btn-sm"
							href="${pageContext.request.contextPath }/AddCart?id=<%=mit.getId() %>&did=<%=mit.getId() %>">
								<i class="fa-solid fa-trash"></i>
						</a>
						</td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
				<tfoot>

					<tr>
						<td colspan="1" class="hidden-xs"></td>
						<td colspan="1" class="hidden-xs"></td>
						<td colspan="2" class="hidden-xs"></td>

						<td class="hidden-xs text-center"><strong>Total $ <%=count%></strong></td>
						<td><a href="purchace.jsp?buy=<%=count%>"
							class="btn btn-success btn-block">Buy <i
								class="fa fa-angle-right"></i>
						</a></td>
					</tr>
				</tfoot>
			</table>

		</div>
		<%
		}
		%>
	</section>
	<section class="container-flex mt-5  mx-auto">
		<%
		if (cart==null && AllOrder != null) {
		%>
		<h2>Your Recente Order</h2>
		<div class="container">
			<table id="cart" class="table table-hover table-condensed">
				<thead>
					<tr>
						<th style="width: 5%">Name</th>
						<th style="width: 5%">Price</th>

					</tr>
				</thead>
				<tbody>

					<%
					for (MenuItem mit : AllOrder) {
						
					%>

					<tr>
						<td data-th="Price"><%=mit.getName()%></td>
						<td data-th="Price">
							<%
							int y = Integer.parseInt(mit.getPrice());
							int w = (int) y;
							int z = mit.getDiscount();
							double x = 0, k = 0;

							x = (w * z) / 100;
							k = w - x;
							%> <%=k%> <%
 try {
 	count += k;
 } catch (Exception e) {

 }
 
 %>
						</td>

					</tr>
					<%			
					}
					
		}
		%>
				
					<tr>
						<td>Total</td>
						<td data-th="Price"><%=count%></td>


					</tr>
					</tbody>

			</table>

		</div>

	
	</section>
</body>
</html>