<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
body {
	background: rgb(113, 24, 166);
	background: linear-gradient(90deg, rgba(113, 24, 166, 0.9822129535407913)
		0%, rgba(43, 194, 92, 0.9514006286108193) 64%, rgba(231, 200, 31, 1)
		100%);
		overflow: hidden;
}
</style>
<%@ include file="AllLinks.jsp"%>
</head>
<body>
<%request.getSession().invalidate(); %>
	<section class="mt-5 container-fluid mx-auto row ">
		<div class="col-sm-auto  col-md-auto col-lg-3 mx-auto mt-5">
			<div class="card bg-white mt-5">
				<div class="card-body border border-light">
					<h1 class="text-center">User Login</h1>
					<form action="login" method="post">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Email
								address</label> <input type="text" class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								name="email">

							<c:if test="${not empty msg}">
								<p class="alert alert-success" role="alert">${msg}</p>
								<c:remove var="msg" />
							</c:if>

						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" class="form-label">password</label>
							<input type="text" class="form-control"
								id="exampleInputPassword1" name="pass">
							<c:if test="${not empty pmsg}">
								<p class="alert alert-success" role="alert">${pmsg}</p>
								<c:remove var="pmsg" />
							</c:if>
						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-primary mr-5" name="forgot">Forgot</button>
							<button type="submit" class="btn btn-primary ms-5" name="submit">login</button>
						</div>

						<p class="text-start mt-3">
							Dont have Account ?<a href="CreateAccount.jsp"> Sign In</a>
						</p>
						<p class="text-end mt-3">
							Login to restorunt<a href="resto_login.jsp"> Sign In</a>
						</p>
					</form>
				</div>
			</div>
		</div>
	</section>

</body>
</html>