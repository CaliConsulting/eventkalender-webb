<%@page import="java.util.List"%>
<%@page import="cali.eventkalender.model.Nation"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="Head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!-- /header -->
	<div class="container mt-2 mb-2">
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="addTitel">Lägg till Nation</h5>
				<form class="needs-validation" novalidate
					action="${pageContext.request.contextPath}/nations/crud"
					method="POST">
					<div class="form-group">
						<label for="nationsname">Namn</label> <input type="text"
							class="form-control" id="nationsnamn" placeholder="Namn"
							required />
					</div>
					<input type="submit" name="submitAddNation">
					<input type="hidden" name="addNation">
				</form>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">Ta bort Nation</h5>
				<div class="form-group">
					<label for="nation">Nation</label> 
					<select class="custom-select"
						id="nationFormControlDelete" required>
						<option value="" disabled="disabled" selected>Välj
							Nation..</option>
						<% List<Nation> nations = (List<Nation>) request.getAttribute("nations");
								for (Nation n : nations) {
									out.print("<option value=\"" + n.getId() + "\">" + n.getId() + " " + n.getName() + "</option>");
								}
						%>
					</select>
				</div>
				<input type="submit" name="submitDeleteNation">
				<input type="hidden" name="deleteNation">
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>