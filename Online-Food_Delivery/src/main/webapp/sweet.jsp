<%@page import="com.food.Entity.MenuItem"%>
<%@page import="java.util.List"%>
<%@page import="com.food.DataBase.RestoruntMenu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Non Veg Section</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
<%@
include
 
file="/css/sweet.css"
 
%>
</style>
</head>
<body>
	<%@ include file="NavBar.jsp"%>
	<div class="container mx-auto bg-image mt-2">
		<h3 class="text-center fs-1 text" >Sweet Menu Items</h3>
		<div class="row row-cols-1 row-cols-lg-3 row-cols-md-2 g-5 py-5  px-5">

			<%
			RestoruntMenu menu = new RestoruntMenu();
			List<MenuItem> rmenu = menu.getAllMenu();
			%>

			<%
			for (MenuItem menuu : rmenu) {
				if(menuu.getType().toLowerCase().equals("sweet"))
				{
			%>
			<div class="col">
				<div class="card" style="width: 18rem;">
					<img src="./images/<%=menuu.getImage()%>" class="card-img-top"
						alt="...">
					<div class="card-body">
						<h5 class="card-title"><%=menuu.getName()%></h5>
						<p class="card-text"><%=menuu.getDescription()%></p>
						<div class="d-flex justify-content-around mb-3">
							<h3><%=menuu.getPrice()%> &#8377
							</h3>
							<%if(menuu.getDiscount()!=0){ %>
								<h5 style="color: red;"><%=menuu.getDiscount() %>% off</h5>
								<%} %>
								<a class="btn btn-primary" href="AddCart?id=<%=menuu.getId()%>">AddCart</a>
								
						</div>
					</div>
				</div>
			</div>

			<%
				}
			}
			%>


		</div>
	</div>
		<%@ include file="Footer.jsp" %>
	
</body>
</html>