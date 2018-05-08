<%@page import="java.util.List"%>
<%@page import="cali.eventkalender.model.Event"%>
<%@page import="cali.eventkalender.model.Nation"%>
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
	<main role="main" class="container mt-2 mb-2">
		<div class="card mb-2">
			<div class="card-body">
				<input class="form-control" id="inputEvent" type="text"
					placeholder="Sök..">
				<table class="table table-hover" id="tableEvent">
					<thead>
						<tr>
							<th>Namn</th>
							<th>Beskrivning</th>
							<th>Nation</th>
							<th>Starttid</th>
							<th>Sluttid</th>
							<th>Inbjudna</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Event> events = (List<Event>) request.getAttribute("events");
							for (Event e : events) {
								out.print("<tr>");
								out.print("<td>" + e.getName() + "</td>");
								out.print("<td>" + e.getSummary() + "</td>");
								out.print("<td>" + e.getNation().getName() + "</td>");
								out.print("<td>" + e.getStartTimeFormatted() + "</td>");
								out.print("<td>" + e.getEndTimeFormatted() + "</td>");
								out.print("<td>" + e.getPersons().size() + "</td>");
								out.print("</tr>");
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		<div class="card mb-2">
			<div class="card-body">
				<input class="form-control" id="inputNation" type="text"
					placeholder="Sök..">
				<table class="table table-hover" id="tableNation">
					<thead>
						<tr>
							<th>Namn</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Nation> nations = (List<Nation>) request.getAttribute("nations");
							for (Nation n : nations) {
								out.print("<tr>");
								out.print("<td>" + n.getName() + "</td>");
								out.print("</tr>");
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
		<div class="card">
			<div class="card-body">
				<input class="form-control" id="inputPerson" type="text"
					placeholder="Sök..">
				<table class="table table-hover" id="tablePerson">
					<thead>
						<tr>
							<th>Förnamn</th>
							<th>Efternamn</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Person> persons = (List<Person>) request.getAttribute("persons");
							for (Person p : persons) {
								out.print("<tr>");
								out.print("<td>" + p.getFirstName() + "</td>");
								out.print("<td>" + p.getLastName() + "</td>");
								out.print("</tr>");
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>