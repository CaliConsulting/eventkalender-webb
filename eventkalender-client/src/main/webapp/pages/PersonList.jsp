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
		<div class="card">
			<div class="card-body">
				<h5 class="card-title text-center">Personer</h5>
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