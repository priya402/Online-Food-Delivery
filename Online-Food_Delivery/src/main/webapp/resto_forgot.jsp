<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot</title>
</head>
<body >
<%@ include file="AllLinks.jsp" %>
	<section class="mt-5 container-flex  mx-auto row ">
		<div class="col-sm-auto  col-md-auto col-lg-3 mx-auto mt-5">
			<div class="card bg-white mt-5">
				<div class="card-body border border-light">
					<h1 class="text-center">Forgot</h1>
					<form action="RestoForgot" method="post">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Email
								address</label> <input type="email" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								name="email" required="required">
						</div>
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Enter Ph.no
								</label> <input type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								name="rno" required="required">
						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" class="form-label">password</label>
							<input type="text" class="form-control"
								id="exampleInputPassword1" name="pass" required="required">

						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary mr-5" name="save">Save
								Changes</button>
						</div>

						
					</form>
				</div>
			</div>
		</div>
	</section>

</body>
</html>