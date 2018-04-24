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
		<table>
			<tr>
				<th>Namn</th>
				<th>Beskrivning</th>
				<th>Nation</th>
				<th>Start tid</th>
				<th>Stängning</th>
				<th>Inbjudna</th>
			</tr>
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
	</table>
	</div>
	<footer> 
		<%@ include file = "Footer.jsp" %>
	</footer>
	<img src="<%= request.getAttribute("weatherlink") %>">
</body>
</html>