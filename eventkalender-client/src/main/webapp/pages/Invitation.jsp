<%@page import="java.util.List"%>
<%@page import="cali.eventkalender.model.Event"%>
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
	<main role="main" class="container-fluid mt-2 mb-2">
	<div class="card">
		<form action="${pageContext.request.contextPath}/invitations"
			method="POST">
			<div class="card invitePerson">
				<div class="card-body">
					<input class="form-control" id="myInputPerson" type="text"
						placeholder="Sök..">
					<table class="table table-hover" id="myPersonTable">
						<thead>
							<tr>
								<th>Förnamn</th>
								<th>Efternamn</th>
								<th>Välj</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Person> persons = (List<Person>) request.getAttribute("persons");
								for (Person p : persons) {
									out.print("<tr>");
									out.print("<td>" + p.getFirstName() + "</td>");
									out.print("<td>" + p.getLastName() + "</td>");
							%>
							<td><input type="checkbox" name="persons"
								value="<%=p.getId()%>"></td>
							<%
								out.print("</tr>");
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<div class="card inviteEvent">
				<div class="card-body">
					<input class="form-control" id="myInputEvent" type="text"
						placeholder="Sök..">
					<table class="table table-hover" id="myEventTable">
						<thead>
							<tr>
								<th>Namn</th>
								<th>Nation</th>
								<th>Starttid</th>
								<th>Sluttid</th>
								<th>Inbjudna</th>
								<th>Välj</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Event> events = (List<Event>) request.getAttribute("events");
								for (Event e : events) {
									out.print("<tr>");
									out.print("<td>" + e.getName() + "</td>");
									out.print("<td>" + e.getNation().getName() + "</td>");
									out.print("<td>" + e.getStartTimeFormatted() + "</td>");
									out.print("<td>" + e.getEndTimeFormatted() + "</td>");
									out.print("<td>" + e.getPersons().size() + "</td>");
							%>
							<td><input type="checkbox" name="events"
								value="<%=e.getId()%>"></td>
							<%
								out.print("</tr>");
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
			<div class="card inviteControls">
				<div class="card-body">
					<button type="submit" class="btn btn-dark">Bjud in</button>
					<input type="hidden" name="operation" value="InviteToEvents">
				</div>
			</div>
		</form>
	</div>
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>