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
		<form class="needs-validation" novalidate action="${pageContext.request.contextPath}/persons/crud" method="POST">
			<div class="form-group">
				<label for="forname">F�rnamn:</label> 
				<input type="text" class="form-control" id="forname" placeholder="F�rnamn" required/> 
				<label for="lastname">Efternamn:</label>
				<input type="text" class="form-control" id="lastname" placeholder="Efternamn" required/>

				<input type="submit" name="registerperson"/>
			</div>
		</form>
	</div>
	<footer>
		<%@ include file = "Footer.jsp" %>
	</footer>
</body>
</html>