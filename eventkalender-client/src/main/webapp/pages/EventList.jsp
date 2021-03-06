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
	<main class="container mt-2 mb-2">
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="card-title text-center">Evenemang</h5>
				<input class="form-control" id="inputEvent" type="text"
					placeholder="Sök...">
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
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>