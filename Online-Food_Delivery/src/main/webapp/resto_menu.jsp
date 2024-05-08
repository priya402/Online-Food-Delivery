	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${login ne 'log'}">
		<c:redirect url="resto_login.jsp"></c:redirect>
	</c:if>
<%@ include file="AllLinks.jsp"%>
<style>
	<%@ include file="/css/navbar.css"%>
</style>
<nav
	class="navbar navbar-expand-lg bg-body-tertiary   bg-custom  mx-auto	 ">
	<!-- 	<div class="container-flex"> -->
	<a class="navbar-brand  "
		style="font-family: sans-serif; font-size: 2rem; font-style: italic;"><img
		alt="cant find" src="./images/logo1.png" style="size: 2rem;">
		The Greps </a>
	<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
		data-bs-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<!-- 			<span class="navbar-toggler-icon"></span> -->
		<i class="fa-solid fa-bars-staggered "></i>
	</button>
	<div class="collapse  navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav ms-auto mb-1 mb-lg-0 text-center ">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="restorunt.jsp"><i
					class="fa-solid fa-house"></i> Home</a></li>

			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="resto_order.jsp"><i class="fa-solid fa-bag-shopping"></i> Orders</a></li>

			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="resto_Stat.jsp"><i class="fa-solid fa-chart-column"></i> Statistics</a></li>
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="Delivery_Boy.jsp"><i class="fa-solid fa-user-nurse"></i>
					Jobs</a></li>
				<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="resto_login.jsp"><i class="fa-solid fa-arrow-right-from-bracket"></i> LogOut</a></li>

		</ul>

	</div>
	<!-- 	</div> -->
</nav>