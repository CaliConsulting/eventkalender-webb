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
		<form class="needs-validation" novalidate action="${pageContext.request.contextPath}/nations/crud" method="POST">
			<div class="form-group">
				<label for="nationsname">Nationsnamn:</label> 
				<input type="text" class="form-control" id="nationsnamn" placeholder="Nationsnamn" required/> 
  			    </div>
				<input type="submit" name="registernation"/>
			</div>
		</form>
	</div>
	<footer>
		<%@ include file = "Footer.jsp" %>
	</footer>
</body>
</html>