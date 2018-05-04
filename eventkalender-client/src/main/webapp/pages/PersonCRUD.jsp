<%@page import="java.util.List"%>
<%@page import="cali.eventkalender.model.Person"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!-- /header -->
	<main class="container mt-2 mb-2">
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="addTitel">Lägg till Person</h5>
				<form class="needs-validation" novalidate action="${pageContext.request.contextPath}/persons/crud" method="POST">
					<div class="form-group">
						<label for="firstName">Förnamn</label> 
						<input type="text" class="form-control" id="firstName" name="firstName" placeholder="Förnamn" 
						required>
						<label for="lastName">Efternamn</label>
						<input type="text" class="form-control" id="lastName" name="lastName" placeholder="Efternamn"
							required>
					</div>
					<input type="submit" name="submitAddPerson">
					<input type="hidden" name="operation" value="addPerson">
				</form>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">Ta bort Person</h5>
				<form action="${pageContext.request.contextPath}/persons/crud" method="POST" novalidate class="needs-validation">
					<div class="form-group">
						<label for="person">Person</label> 
						<select class="custom-select"
							id="id" name="id" required>
							<option value="" disabled="disabled" selected>Välj
								Person..</option>
							<% List<Person> persons = (List<Person>) request.getAttribute("persons");
									for (Person p : persons) {
										out.print("<option value=\"" + p.getId() + "\">" + p.getId() + " " + p.getFirstName() + " " + p.getLastName()+ "</option>");
									}
							%>
						</select>
					</div>
					<input type="submit" name="submitDeletePerson">
					<input type="hidden" name="operation" value="deletePerson">
				</form>
			</div>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>