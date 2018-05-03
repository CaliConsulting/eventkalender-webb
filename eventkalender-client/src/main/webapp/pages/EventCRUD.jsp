<%@page import="java.util.List"%>
<%@page import="cali.eventkalender.model.Nation"%>
<%@page import="cali.eventkalender.model.Event"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!-- /header -->
	<main role="main" class="container mt-2">
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="addTitel">Lägg till Evenemang</h5>
				<form class="needs-validation" novalidate
					action="${pageContext.request.contextPath}/events/crud"
					method="POST">
					<div class="form-group">
						<label for="Name">Namn</label>
							<input type="text" class="form-control" id="same" name="same" placeholder="Namn" required> 
						<label for="nationTextarea">Beskrivning</label>
							<textarea class="form-control" id="summary" name="summary" rows="4"
								placeholder="Ange en beskrivning för ditt evenemang" required></textarea>
						<label for="Nation">Nation</label> 
							<select class="custom-select form-control" id="nation" name="nation" required>
								<option value="" disabled="disabled" selected>
								Välj Nation...</option>
								<% List<Nation> nations = (List<Nation>) request.getAttribute("nations");
								for (Nation n : nations) {
									out.print("<option value=\"" + n.getId() + "\">" + n.getId() + " " + n.getName() + "</option>");
								}
								%>
							</select>
						<label for="startTime">Starttid</label>
							<input type="datetime-local" class="form-control" id="startTime" name="startTime" required>
						<label for="endTime">Sluttid</label>
							<input type="datetime-local" class="form-control" id="endTime" name="endTime" required>
					</div>
					<input type="submit" name="submitAddEvent">
					<input type="hidden" name="addEvent">
				</form>
			</div>
		</div>
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="addTitel">Ta bort Evenemang</h5>
				<div class="form-group">
					<label for="event">Evenemang</label> 
					<select class="custom-select"
						id="eventFormControlDelete" required>
						<option value="" disabled="disabled" selected>Välj
							Evenemang..</option>
						<% List<Event> events = (List<Event>) request.getAttribute("events");
								for (Event e : events) {
									out.print("<option value=\"" + e.getId() + "\">" + e.getId() + " " + e.getName() + "</option>");
								}
						%>
					</select>
				</div>
				<input type="submit" name="submitDeleteEvent">
				<input type="hidden" name="deleteEvent"> 
			</div>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>