<!DOCTYPE html>
<html>
	<head>
		<Title>Eventkalender</Title>
		<style>
			body{background-color: powderblue;}
			p {font: Times New Roman; pt: 12;}
		</style>
		<meta charset="UTF-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>
	<body>
		<div class="addPerson">
			<h1>Lägg till person</h1>
			<form action="TestServlet" method="POST">
				<p>Förnamn:</p>
				<input type="Text" name="firstName">
				<p>Efternamn:</p>
				<input type="Text" name="lastName">
				<br>
				<input type="Submit" name="registerPerson">
			</form>
	</div>
	<div class="addNation">
		<h1>Lägg till nation</h1>
		<form>
			<p>Nationsnamn: </p>
			<input type="text" name="nationName">
		</form>
	</div>
	</body>
</html>