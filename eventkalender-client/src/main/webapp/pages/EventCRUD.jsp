<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<header>
		<%@ include file="Header.jsp"%>
	</header>
	<main role="main" class="container">
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">Lägg till</h5>
				<form class="needs-validation" novalidate
					action="${pageContext.request.contextPath}/events/crud"
					method="POST">
					<div class="form-group">
						<label for="eventname">Evenemangsnamn:</label> <input type="text"
							class="form-control" id="eventname" placeholder="Evenemangsnamn"
							required /> <label for="nationTextarea">Evenemangsbeskrivning</label>
						<textarea class="form-control" id="evenemangTextarea" rows="4"
							placeholder="Ange en beskrivning för ditt evenemang" required></textarea>
						<label for="nation">Nation:</label> <select class="custom-select"
							id="eventFormControl" required>
							<option value="" disabled="disabled" selected>Välj
								Nation...</option>
							<option value="1">Malmö Nation</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">BlazeitTest501</option>
						</select>
					</div>
					<input type="submit" name="registerevent" />
				</form>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">Ta bort</h5>
				<div class="form-group">
					<label for="event">Evenemang:</label> 
					<select class="custom-select"
						id="eventFormControlDelete" required>
						<option value="" disabled="disabled" selected>Välj
							Evenemang...</option>
						<option value="1">Event1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">GA-Balen</option>
					</select>
				</div>
				<input type="submit" name="removeEvent" />
			</div>
		</div>
	</main>
	<footer class="footer">
		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>