<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<%@ include file="AllLinks.jsp"%>
<style>
	<%@ include file="/css/navbar.css"%>
</style>
<c:if test="${log ne 'log'}">
		<c:redirect url="Admin.jsp"></c:redirect>
	</c:if>
<nav
	class="navbar navbar-expand-lg bg-body-tertiary   bg-custom  mx-auto	 ">
	<!-- 	<div class="container-flex"> -->
	<a class="navbar-brand  "
		style="font-family: sans-serif; font-size: 2rem; font-style: italic;"
		><img alt="cant find" src="./images/logo1.png"
		style="size: 2rem;"> The Greps </a>
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
				aria-current="page" href="admin_DeliveryBoy.jsp"><i class="fa-solid fa-truck"></i>
					Delivery Boy</a></li>
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="admin_user.jsp"><i class="fa-regular fa-user"></i>
					User's</a></li>
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="admin_resto.jsp"><i class="fa-solid fa-hotel"></i>
					Restorunt's</a></li>
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="Admin_stat.jsp"><i class="fa-solid fa-square-poll-vertical"></i>
					Statistics</a></li>
			
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="Admin.jsp"><i class="fa-solid fa-arrow-right-to-bracket"></i> Logout</a>
					</li>

		</ul>

	</div>
	<!-- 	</div> -->
</nav>