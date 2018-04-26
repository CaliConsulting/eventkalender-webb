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
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">Lägg till</h5>
				<form class="needs-validation" novalidate
					action="${pageContext.request.contextPath}/nations/crud"
					method="POST">
					<div class="form-group">
						<label for="nationsname">Nationsnamn:</label> <input type="text"
							class="form-control" id="nationsnamn" placeholder="Nationsnamn"
							required />
					</div>
					<input type="submit" name="registernation" />
				</form>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">Ta bort</h5>
				<div class="form-group">
					<label for="nation">Nation:</label> 
					<select class="custom-select"
						id="nationFormControlDelete" required>
						<option value="" disabled="disabled" selected>Välj
							Nation...</option>
						<option value="1">Nation1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">Malmö Nation</option>
					</select>
				</div>
				<input type="submit" name="removeNation" />
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>