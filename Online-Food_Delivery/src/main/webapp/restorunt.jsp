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
	<c:if test="${login ne 'log'}">
		<c:redirect url="resto_login.jsp"></c:redirect>
	</c:if>
	<%@ include file="resto_menu.jsp"%>
	<%
	int rid = (int) session.getAttribute("rid");

	RestoruntMenu db = new RestoruntMenu();
	List<MenuItem> menu = db.getAllMenu();
	HttpSession sesion=request.getSession();
	//String rid=(String)session.getAttribute("rid");
	%>

	<section class="container-flex mt-2  mx-auto">
		<h1 class="text-center mb-3">Menu Items</h1>

		<div class="container table-responsive">

			<table id="cart"
				class="table table-hover border table-condensed container"
				style="background: fuchsia !important;">
				<thead>
					<tr>
						<th style="width: 10%">Image</th>
						<th style="width: 10%">Name</th>
						<th style="width: 5%">Type</th>
						<th style="width: 5%">Price</th>
						<th style="width: 30%">Description</th>
						<th style="width: 5%">Discount</th>
						<th style="width: 20%" colspan="1">Operation
							<button class="btn btn-success btn-block ms-4"
								data-bs-toggle="modal" data-bs-target="#insert">Add New
							</button>
						</th>
					</tr>
				</thead>
				<tbody>

					<%
					for (MenuItem menuu : menu) {
						if (menuu.getResto_id() == rid) {
					%>
					<tr>
						<td data-th="Product">
							<div class="row ">
								<div class="col-sm-2 hidden-xs">
									<img src="./images/<%=menuu.getImage()%>" alt="..."
										class="img-responsive rounded mx-auto d-block" />
								</div>

							</div>
						</td>
						<td data-th="Price"><%=menuu.getName()%></td>
						<td data-th="Price"><%=menuu.getType()%></td>

						<td data-th="Price"><%=menuu.getPrice()%> &#8377</td>
						<td data-th="Price"><%=menuu.getDescription()%></td>
						<td data-th="Price"><%=menuu.getDiscount()%> %</td>

						<td class="actions " data-th="">
						<a
							class="btn btn-danger btn-sm mt-2" 
							href="restorunt?uid=<%=menuu.getId()%>&urid=<%=menuu.getResto_id() %>" >
								<i class="fa-solid fa-arrows-rotate"> Update</i>
						</a> <a class="btn btn-danger btn-sm mt-2 "
							href="restorunt?did=<%=menuu.getId()%>&rdid=<%=menuu.getResto_id()%>">
								<i class="fa-solid fa-trash"> Delete</i>
						</a></td>
					</tr>

					<%
					 }
					}
					%>

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
					<h5 class="modal-title" id="exampleModalLabel">Product Name</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body">
					<form action="restorunt" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label for="exampleFormControlFile1">Example file input</label> <input
								type="file" class="form-control-file"
								id="exampleFormControlFile1" name="image" required="required">
						</div>
						<fieldset>
							<div class="form-group">
								<label for="disabledTextInput">Enter Name</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Name" name="name">
							</div>
							<div class="form-group">
								<label for="disabledTextInput">Enter Price</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Price" name="price">
							</div>
							<div class="form-group">
								<label for="disabledTextInput">Enter Discount</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Discount" name="discount" value="1">
							</div>
							<div class="form-group">
								<label for="disabledTextInput">Enter Type
									(veg,nonveg,sweet,combo)</label> <input type="text" id="disabledTextInput"
									class="form-control" placeholder="type" name="type">
							</div>
							<div class="form-group">
								<label for="disabledTextInput">Enter Description</label> <input
									type="text" id="disabledTextInput" class="form-control"
									placeholder="Description" name="description">
							</div>



						</fieldset>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" name="add">add
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