<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Eventkalender</title>
<link rel="stylesheet" href="webapp/css/bootstrap.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<link rel="icon" type="image/png" href="webapp/img/Cali-16x16.png" sizes="16x16">
<link rel="icon" type="image/png" href="webapp/img/Cali-32x32.png" sizes="32x32">
<link rel="icon" type="image/png" href="webapp/img/Cali-96x96.png" sizes="96x96">
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-light bg-light">
  <a class="navbar-brand" href="#">
  		<img src="img/Cali.png" Width="30" Height="30">
  		Eventkalender
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Evenemangslista</a>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Lägg till/Ta bort:
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Evenemang<span class="sr-only">(current)</span></a>
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
			<label for="Eventname">Evenemangsnamn:</label> 
			<input type="Text" class="form-control" id="eventName"/> 
			<label for="Nation">Nation:</label>
			<input list="Nations" class="form-control"	name="Nations" id="Nations">
				<datalist id="Nations">
					<option value="Autogenerad lista från databasen">
				</datalist>
			<input type="Submit" name="registerPerson"/>
		</div>
	</form>
</div>
</body>
</html>