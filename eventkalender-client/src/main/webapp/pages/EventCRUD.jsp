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
		<form action="TestServlet" method="POST">
			<div class="form-group">
				<label for="eventname">Evenemangsnamn:</label> 
				<input type="text" class="form-control" id="eventname" placeholder="Evenemangsnamn"/>
				<label for="nationTextarea">Evenemangsbeskrivning</label>
    			<textarea class="form-control" id="evenemangTextarea" rows="4" placeholder="Ange en beskrivning av ditt evenemang"></textarea> 
				<label for="nation">Nation:</label>
			    <select class="form-control" id="nationFormControl">
			      <option>Malmö Nation</option>
			      <option>2</option>
			      <option>3</option>
			      <option>4</option>
			      <option>BlazeitTest501</option>
  				  </select>
			</div> 
 		 <input type="submit" name="registerevent"/>
		</form>
	</div>
	<footer>
		<%@ include file = "Footer.jsp" %>
	</footer>
</body>
</html>