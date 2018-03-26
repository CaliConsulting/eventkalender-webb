<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Eventkalender</title>
<link rel="stylesheet" href="css/bootstrap.min.css"></link>
<script src="js/bootstrap.min.js"></script>
<script src="jquery/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">
				<img src="img/Cali.png" class="d-inline-block align top" width="30" height="30" alt=""/>unt	
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="#">
							Evenemangslista
							<span class="sr-only">(current)</span>
						</a>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" 
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Lägg till
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">Action</a>
							<a class="dropdown-item" href="#">Another action</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="#">Something else here</a>
						</div></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
		<div class="container">
			<form action="TestServlet" method="POST">
				<div class="form-group">
					<label for="firstName">Förnamn:</label> 
					<input type="Text" class="form-control" id="firstName"/> 
					<label for="lastName">Efternamn:</label>
					<input type="Text" class="form-control" id="lastName"/> 
					<input type="Submit" name="registerPerson"/>
				</div>
			</form>
			<div>
				<h1>Lägg till nation</h1>
				<form>
					<p>Nationsnamn:</p>
					<input type="text" name="nationName">
				</form>
			</div>
		</div>
	</div>
</body>
</html>