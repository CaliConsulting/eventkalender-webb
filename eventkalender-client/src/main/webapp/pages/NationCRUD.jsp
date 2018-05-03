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
				<h5 class="addTitel">L�gg till Nation</h5>
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
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">Ta bort Nation</h5>
					<form action="${pageContext.request.contextPath}/nations/crud" method="POST" novalidation class="needs-validation">
						<div class="form-group">
							<label for="nation">Nation</label> 
							<select class="custom-select" id="id" name="id" required>
								<option value="" disabled="disabled" selected>
								V�lj Nation..</option>
								<% List<Nation> nations = (List<Nation>) request.getAttribute("nations");
										for (Nation n : nations) {
											out.print("<option value=\"" + n.getId() + "\">" + n.getId() + " " + n.getName() + "</option>");
										}
								%>
							</select>
							<input type="submit" name="submitDeleteNation">
							<input type="hidden" name="operation" value="deleteNation">
						</div>
					</form>
				</div>
			</form>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>