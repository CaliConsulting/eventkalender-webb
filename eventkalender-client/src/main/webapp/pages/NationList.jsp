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
				<h5 class="card-title text-center">Nationer</h5>
				<input class="form-control" id="inputNation" type="text"
					placeholder="Sök...">
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
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>