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
		<form action="${pageContext.request.contextPath}/nations/crud" method="POST">
			<div class="form-group">
				<label for="nationsname">Namn:</label> 
				<input type="text" class="form-control" id="nationsnamn" placeholder="Din Nation"/> 
				 <small id="nationHelp" class="form-text text-muted">Ange din nation</small>
				<input type="submit" name="registernation"/>
			</div>
		</form>
	</div>
	<footer>
		<%@ include file = "Footer.jsp" %>
	</footer>
</body>
</html>