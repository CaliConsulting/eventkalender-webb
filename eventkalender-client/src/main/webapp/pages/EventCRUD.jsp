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
		<form action="TestServlet" method="POST">
			<div class="form-group">
				<label for="Eventname">Evenemangsnamn:</label> 
				<input type="Text" class="form-control" id="eventName"/> 
				<label for="Nation">Nation:</label>
				<input list="Nations" class="form-control"	name="Nations" id="Nations">
					<datalist id="Nations">
						<option value="Autogenerad lista från databasen">
					</datalist>
				<input type="Submit" name="registerPerson"/>
			</div>
		</form>
	</div>
	<footer>
		<%@ include file = "Footer.jsp" %>
	</footer>
</body>
</html>