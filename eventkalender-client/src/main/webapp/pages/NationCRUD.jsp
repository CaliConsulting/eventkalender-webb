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
	<main role="main" class="container mt-2 mb-2">
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="addTitel">Lägg till Nation</h5>
				<form class="needs-validation" novalidate action="${pageContext.request.contextPath}/nations/crud" method="POST">
					<div class="form-group">
						<label for="nationName">Namn</label>
							<input type="text" class="form-control" id="nationName" name="nationName" placeholder="Namn" required>
					</div>
					<input type="submit" name="submitAddNation">
					<input type="hidden" name="operation" value="addNation">
				</form>
			</div>
		</div>
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="addTitel">Uppdatera Nation</h5>
				<form class="needs-validation" novalidate action="${pageContext.request.contextPath}/nations/crud" method="POST">
					<div class="form-group">
						<select class="custom-select form-control" id="updateNationList" name="updateNationList" required>
							<option value="" disabled="disabled" selected>
							Välj Nation...</option>
							%>
						</select>
						<label for="name">Namn</label>
							<input type="text" class="form-control" id="updateNationName" name="updateNationName" placeholder="Namn" required> 
					</div>
					<input type="submit" name="submitUpdateNation">
					<input type="hidden" name="operation" value="updateNation">
				</form>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">Ta bort Nation</h5>
				<form action="${pageContext.request.contextPath}/nations/crud" method="POST" novalidation class="needs-validation">
						<div class="form-group">
						<label for="nation">Nation</label> 
						<select class="custom-select" id="id" name="id" required>
							<option value="" disabled="disabled" selected>
							Välj Nation..</option>
							<% List<Nation> nations = (List<Nation>) request.getAttribute("nations");
								for (Nation n : nations) {
									out.print("<option value=\"" + n.getId() + "\">" + n.getId() + " " + n.getName() + "</option>");
								}
							%>
						</select>
					</div>
					<input type="submit" name="submitDeleteNation">
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