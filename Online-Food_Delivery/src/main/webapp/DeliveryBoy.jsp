<%@page import="com.food.Entity.User"%>
<%@page import="com.food.Entity.MenuItem"%>
<%@page import="com.food.DataBase.RestoruntMenu"%>
<%@page import="com.food.DataBase.RestoruntDbOperation"%>
<%@page import="com.food.DataBase.UserDbOperation"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.food.Entity.Orders"%>
<%@page import="java.util.List"%>
<%@page import="com.food.DataBase.Order"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
<style type="text/css">
body {
	background-color: graytext !important;
}
</style>
</head>
<body>

	<%@ include file="AllLinks.jsp"%>
	
	<c:if test="${log ne 'log' }">
		<c:redirect url="DeliveryBoyLogin.jsp" />
	</c:if>
	<section class="container-flex mt-2  mx-auto">
		<h1 class="ms-2 mb-4 text-center"
			style="font-family: sans-serif; font-style: italic;">Todays
			Orders</h1>

		<div class="container ">
			<table id="cart" class="table table-hover border table-condensed">
				<thead>
					<tr>
						<th style="width: 20%">Item Name</th>
						<th style="width: 20%">Customer Name</th>
						<th style="width: 20%">Customer No</th>
						<th style="width: 30%; height: 30%">Operation</th>
					</tr>
				</thead>
				<tbody>
					<%
					UserDbOperation udb=new UserDbOperation();
					List<User> user=udb.getAll();
					
					RestoruntMenu menu=new RestoruntMenu();
					List<MenuItem> item=menu.getAllMenu();
					if(session==null){
						%>
						<%response.sendRedirect("DeliveryBoyLogin.jsp"); %>
					<% }
					
					Order odr=new Order();
					List<Orders> odrs=odr.getOrder();
					int id=(int)session.getAttribute("boyid");
					
					for(Orders od:odrs)
					{
						if(od.getDid()==id){
						for(User u:user ){
							for(MenuItem i:item){
						//if(od.getCid().equals(u.getMno()) || od.getMid()==i.getId()){
					%>
					<tr>
						<td data-th="price"><%=i.getName() %></td>
						<td data-th="Price"><%=u.getUname() %></td>
						<td data-th="Price"><%=u.getMno() %></td>
			

						<td class="actions " data-th=""><a
							class="btn btn-danger btn-sm mb-3"
							href="DeliveryBoyOrder?astatus=<%=i.getId()%>"> <i
								class="fa-solid fa-arrows-rotate"> Accept</i>
						</a></td>
					</tr>

					<%//}
							}
							}
						}
						}
					
					
					%>
				</tbody>
			</table>
		</div>

	</section>
</body>
</html>