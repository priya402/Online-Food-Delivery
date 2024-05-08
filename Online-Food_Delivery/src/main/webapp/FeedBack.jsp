<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title></title>
<style type="text/css">
<%@
include
 
file="/css/feedback.css"
 
%>
</style>
</head>
<body style="background: pink !important;">
	<%@ include file="NavBar.jsp"%>
	<section class="mt-5 container-flex  mx-auto row mb-5">
		<div class="col-sm-auto  col-md-auto col-lg-3 mx-auto">
			<div class="card bg-white ">
				<div class="card-body border border-light">
					<form class="fs-5 mt-3 " action="FeedBack" method="post">
						<fieldset>
							<legend class="text-center mb-4 fs-3">
								<span class="text-warning"> FeedBack</span>
							</legend>
							<div class="mb-3">
								<label for="disabledTextInput" class="form-label">Enter
									Name</label> <input type="text" id="disabledTextInput"
									class="form-control" name="uname" required="required">
							</div>
							<div class="mb-3">
								<label for="disabledTextInput" class="form-label">Enter
									Email</label> <input type="email" id="disabledTextInput"
									class="form-control" name="email" required="required">
							</div>
							<div class="mb-3">
								<label for="disabledTextInput" class="form-label">Enter
									Phone No</label> <input type="text" id="disabledTextInput"
									class="form-control" name="pno" required="required" maxlength="10">
							</div>
							<div class="form-group">
								<label for="exampleFormControlTextarea1">Enter
									Feedback</label>
								<textarea class="form-control" id="exampleFormControlTextarea1"
									rows="3" name="feedback"></textarea>
							</div>


							<div class="d-flex  mx-auto">
								<button type="submit" class="btn btn-danger mx-auto" name="sub">Submit</button>
							</div>


						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</section>
	<section>
		<%@ include file="Footer.jsp"%>
	</section>
</body>

</html>