<!DOCTYPE html>
<html>
	<head>
		<Title>Eventkalender</Title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script src="js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<style>
		</style>
		<meta charset="UTF-8"/>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	</head>
	<body>
	<div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#MyNavbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar right">
					<li class="active"><a href="#">Hem</a></li>
					<li><a href="#">Nation</a></li>
					<li><a href="#">Person</a></li>
					<li><a href="#">Event</a></li>
				</ul>
			</div>
			
		</div>
	</nav>
	</div>
	<form action="TestServlet" method="POST">
		<div class="form-group">
			<label for="firstName">Förnamn:</label>
			<input type="Text" class="form-control" id="firstName">
			<label for="lastName">Efternamn:</label>
			<input type="Text" class="form-control" id="lastName">
			<input type="Submit" name="registerPerson">	
		</div>
	</form>
	<div class="addNation">
		<h1>Lägg till nation</h1>
		<form>
			<p>Nationsnamn: </p>
			<input type="text" name="nationName">
		</form>
	</div>
	</body>
</html>