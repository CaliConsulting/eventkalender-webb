<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!-- /header -->
	<div class="container">
		<form>
			<div class="form-group">
				<label for="exampleFormControlInput1">Email address</label> <input
					type="email" class="form-control" id="exampleFormControlInput1"
					placeholder="name@example.com">
			</div>
			<div class="form-group">
				<label for="exampleFormControlSelect1">Antal biljetter</label> <select
					class="form-control" id="exampleFormControlSelect1">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1">Ange ditt för- och
					efternamn</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3"></textarea>
			</div>
		</form>
		<a href="${pageContext.request.contextPath}/prepurchase/info"
			class="btn btn-outline-dark float-left">Till betalning</a>
	</div>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>