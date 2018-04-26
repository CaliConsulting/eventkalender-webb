<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">L�gg till</h5>
				<form class="needs-validation" novalidate
					action="${pageContext.request.contextPath}/persons/crud"
					method="POST">
					<div class="form-group">
						<label for="forname">F�rnamn:</label> <input type="text"
							class="form-control" id="forname" placeholder="F�rnamn" required />
						<label for="lastname">Efternamn:</label> <input type="text"
							class="form-control" id="lastname" placeholder="Efternamn"
							required />
					</div>
					<input type="submit" name="registerperson" />
				</form>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">Ta bort</h5>
				<div class="form-group">
					<label for="person">Person:</label> 
					<select class="custom-select"
						id="personFormControlDelete" required>
						<option value="" disabled="disabled" selected>V�lj
							Person...</option>
						<option value="1">Person1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">Hampus Sandell</option>
					</select>
				</div>
				<input type="submit" name="removePerson" />
			</div>
		</div>
	</div>
>>>>>>> 50917222beec1bf56f4dff7b8d482f462e5e117c
	<footer class="footer">
		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>