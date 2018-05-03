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
	<div class="container mt-2 mb-2">
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="addTitel">Lägg till Person</h5>
				<form class="needs-validation" novalidate
					action="${pageContext.request.contextPath}/persons/crud"
					method="POST">
					<div class="form-group">
						<label for="forname">Förnamn</label> <input type="text"
							class="form-control" id="forname" placeholder="Förnamn" required />
						<label for="lastname">Efternamn</label> <input type="text"
							class="form-control" id="lastname" placeholder="Efternamn"
							required />
					</div>
					<input type="submit" name="submitAddPerson">
					<input type="hidden" name="addPerson">
				</form>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<h5 class="addTitel">Ta bort Person</h5>
				<div class="form-group">
					<label for="person">Person</label> 
					<select class="custom-select"
						id="personFormControlDelete" required>
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
				<input type="hidden" name="deletePerson">
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>