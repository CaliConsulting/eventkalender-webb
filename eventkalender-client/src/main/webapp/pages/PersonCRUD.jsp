<!DOCTYPE html>
<html>
<head>
	<%@ include file = "Head.jsp" %>
</head>
<body>
	<header>
		<%@ include file = "Header.jsp" %>
	</header>
		<div class="container">
		<form action="${pageContext.request.contextPath}/persons/crud" method="POST">
			<div class="form-group">
				<label for="forname">Förnamn:</label> 
				<input type="text" class="form-control" id="forname" placeholder="Förnamn"/> 
				<label for="lastname">Efternamn:</label>
				<input type="text" class="form-control" id="lastname" placeholder="Efternamn">

				<input type="submit" name="registerperson"/>
			</div>
		</form>
	</div>
			<div class="container">
		<form action="${pageContext.request.contextPath}/persons/crud" method="POST">
			<div class="form-group">
				<label for="forname">Förnamn:</label> 
				<input type="text" class="form-control" id="forname" placeholder="Förnamn"/> 
				<label for="lastname">Efternamn:</label>
				<input type="text" class="form-control" id="lastname" placeholder="Efternamn">

				<input type="submit" name="registerperson"/>
			</div>
		</form>
	</div>
	<footer>
		<%@ include file = "Footer.jsp" %>
	</footer>
</body>
</html>