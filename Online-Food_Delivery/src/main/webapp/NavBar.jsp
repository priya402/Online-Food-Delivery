<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<%@ include file="AllLinks.jsp"%>
<style>
	<%@ include file="/css/navbar.css"%>
</style>

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
				aria-current="page" href="Home.jsp"><i class="fa-solid fa-house"></i>
					Home</a></li>

			<li class="nav-item dropdown navbar-light"><a
				class="nav-link dropdown-toggle" href="#" role="button"
				data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fa-solid fa-book-open-reader"></i> Menu Card </a>
				<ul class="dropdown-menu" style="overflow: hidden;">
					<li><a class="dropdown-item" href="VegMenu.jsp">Vegeterian</a></li>
					<li><a class="dropdown-item" href="NonVeg.jsp">Non
							Vegeterian</a></li>
					<li><a class="dropdown-item" href="sweet.jsp">Sweet Dish</a></li>
					<li><a class="dropdown-item" href="partyMenu.jsp">Combo Pack</a></li>

				</ul></li>
			
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="Accout.jsp"><i class="fa-solid fa-cart-shopping"></i>
					Cart</a></li>
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="FeedBack.jsp"><i class="fa-solid fa-comments"></i>
					FeedBack</a></li>
			
			
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="login.jsp"><i
					class="fa-solid fa-right-to-bracket"></i> Login</a>
					</li>

		</ul>

	</div>
	<!-- 	</div> -->
</nav>