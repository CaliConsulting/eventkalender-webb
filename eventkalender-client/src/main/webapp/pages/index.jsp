<%@page import="java.util.List"%>
<%@page import="cali.eventkalender.model.Event" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file = "Head.jsp" %>
</head>
<body>
	<header>
		<%@ include file = "Header.jsp" %>
	</header>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Namn</th>
					<th>Beskrivning</th>
					<th>Nation</th>
					<th>Start tid</th>
					<th>Stängning</th>
					<th>Inbjudna</th>
				</tr>
			</thead>
			<tbody>
			<% 	List<Event> events = (List<Event>) request.getAttribute("events");
					
					for(Event e: events){
						out.print("<tr>");
						out.print("<td>" + e.getName() + "</td>");
						out.print("<td>" + e.getSummary() + "</td>");
						out.print("<td>" + e.getNation().getName() + "</td>");
						out.print("<td>" + e.getStartTime() + "</td>");
						out.print("<td>" + e.getEndTime() + "</td>");
						out.print("<td>" + e.getPersons().size() + "</td>");
						out.print("</tr>");
					}
				%>
			</tbody>
		</table>
	</div>
	<footer class="footer">
		<%@ include file = "Footer.jsp" %>
	</footer>
</body>
</html>