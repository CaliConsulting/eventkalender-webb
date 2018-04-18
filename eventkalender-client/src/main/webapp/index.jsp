<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Eventkalender</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<link rel="icon" type="image/png" href="img/Cali-16x16.png" sizes="16x16">
<link rel="icon" type="image/png" href="img/Cali-32x32.png" sizes="32x32">
<link rel="icon" type="image/png" href="img/Cali-96x96.png" sizes="96x96">
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-light bg-light">
  <a class="navbar-brand" href="Eventkalender">
  		<img src="img/Cali.png" Width="30" Height="30">
  		Eventkalender
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Eventkalender">Evenemangslista <span class="sr-only">(current)</span></a>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Lägg till/Ta bort:
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="events/crud">Evenemang</a>
          <a class="dropdown-item" href="#">Nationer</a>
          <a class="dropdown-item" href="#">Personer</a>
        </div>
      </li>
    </ul>
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
			<input type="Submit" name="registerNation"/>
		</form>
	</div>
</div>
</body>
</html>