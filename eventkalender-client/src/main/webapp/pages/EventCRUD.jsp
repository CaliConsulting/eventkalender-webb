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
						<label for="name">Namn</label>
							<input type="text" class="form-control" id="name" name="name" placeholder="Namn" required> 
						<label for="summary">Beskrivning</label>
							<textarea class="form-control" id="summary" name="summary" rows="4"
								placeholder="Ange en beskrivning för ditt evenemang" required></textarea>
						<label for="nations">Nation</label> 
							<select class="custom-select form-control" id="nations" name="nations" required>
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
					<input type="hidden" name="operation" value="addEvent">
				</form>
			</div>
		</div>
		<div class="card mb-2">
			<div class="card-body">
				<h5 class="addTitel">Uppdatera Evenemang</h5>
				<form class="needs-validation" novalidate
					action="${pageContext.request.contextPath}/events/crud"
					method="POST">
					<div class="form-group">
						<select class="custom-select"
							id="updateEventList" name="updateEventList" required>
							<option value="" disabled="disabled" selected>
							Välj evenemang..</option>
							<% List<Event> events = (List<Event>) request.getAttribute("events");
								for (Event e : events) {
									out.print("<option value=\"" + e.getId() + "\">" + e.getId() + " " + e.getName() + "</option>");
								}
							%>
						</select>
						<label for="name">Namn</label>
							<input type="text" class="form-control" id="updateEventName" name="updateEventName" placeholder="Namn" required> 
						<label for="summary">Beskrivning</label>
							<textarea class="form-control" id="updateEventSummary" name="updateEventSummary" rows="4"
								placeholder="Ange en beskrivning för ditt evenemang" required></textarea>
						<label for="nations">Nation</label> 
							<select class="custom-select form-control" id="updateEventNations" name="updateEventNations" required>
								<option value="" disabled="disabled" selected>
								Välj Nation...</option>
								<% 
									for (Nation n : nations) {
										out.print("<option value=\"" + n.getId() + "\">" + n.getId() + " " + n.getName() + "</option>");
									}
								%>
							</select>
						<label for="startTime">Starttid</label>
							<input type="datetime-local" class="form-control" id="updateEventStartTime" name="updateEventStartTime" required>
						<label for="endTime">Sluttid</label>
							<input type="datetime-local" class="form-control" id="updateEventEndTime" name="updateEventEndTime" required>
					</div>
					<input type="submit" name="submitUpdateEvent">
					<input type="hidden" name="operation" value="updateEvent">
				</form>
			</div>
		</div>
		<div class="card mb-2">
			<form action="${pageContext.request.contextPath}/events/crud" method="POST" novalidation class="needs-validation">
				<div class="card-body">
					<h5 class="addTitel">Ta bort Evenemang</h5>
					<div class="form-group">
						<label for="event">Evenemang</label> 
						<select class="custom-select"
							id="id" name="id" required>
							<option value="" disabled="disabled" selected>
							Välj evenemang..</option>
							<%
								for (Event e : events) {
									out.print("<option value=\"" + e.getId() + "\">" + e.getId() + " " + e.getName() + "</option>");
								}
							%>
						</select>
					</div>
					<input type="submit" name="submitDeleteEvent">
					<input type="hidden" name="operation" value="deleteEvent"> 
				</div>
			</form>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>