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
	<main class="container mt-2">
		<%@ include file="PostMessage.jsp" %>
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="card-title">Lägg till Nation</h5>
				<form class="needs-validation" novalidate action="${pageContext.request.contextPath}/nations/crud" method="POST">
					<div class="form-group">
						<label for="nationName">Namn</label>
							<input type="text" class="form-control" id="nationName" name="nationName" placeholder="Namn" required>
					</div>
					<input type="submit" name="submitAddNation" class="btn btn-outline-dark" value="Lägg till">
					<input type="hidden" name="operation" value="addNation">
				</form>
			</div>
		</div>
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="card-title">Uppdatera Nation</h5>
				<form class="needs-validation" novalidate action="${pageContext.request.contextPath}/nations/crud" method="POST">
					<div class="form-group" id="formGroupUpdateNation">
						<select class="custom-select form-control" id="updateNationList" name="updateNationList" required>
							<option value="" disabled="disabled" selected>
							Välj nation...</option>
							<% 
								List<Nation> nations = (List<Nation>) request.getAttribute("nations");
								for (Nation n : nations) {
									out.print("<option value=\"" + n.getId() + "\">" + n.getId() + " " + n.getName() + "</option>");
								}
							%>
						</select>
						<label for="name">Namn</label>
							<input type="text" class="form-control" id="updateNationName" name="updateNationName" placeholder="Namn" disabled="disabled" required> 
					</div>
					<input type="submit" name="submitUpdateNation" class="btn btn-outline-dark" value="Uppdatera">
					<input type="hidden" name="operation" value="updateNation">
				</form>
			</div>
		</div>
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="card-title">Ta bort Nation</h5>
				<form action="${pageContext.request.contextPath}/nations/crud" method="POST" class="needs-validation" novalidate>
						<div class="form-group">
						<select class="custom-select" id="id" name="id" required>
							<option value="" disabled="disabled" selected>
							Välj nation...</option>
							<%
								for (Nation n : nations) {
									out.print("<option value=\"" + n.getId() + "\">" + n.getId() + " " + n.getName() + "</option>");
								}
							%>
						</select>
					</div>
					<input type="submit" name="submitDeleteNation" class="btn btn-outline-dark" value="Ta bort">
					<input type="hidden" name="operation" value="deleteNation">
				</form>
			</div>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>