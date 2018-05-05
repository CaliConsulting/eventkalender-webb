<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!-- /header -->
	<div class="container">
	<p>
  <a class="btn btn-outline-dark btn-lg" data-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Vilka vi �r</a>
  <button class="btn btn-outline-dark btn-lg" type="button" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2">v�rt milj�t�nk</button>
  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2">Toggle both elements</button>
</p>
<div class="row">
  <div class="col">
    <div class="collapse multi-collapse" id="multiCollapseExample1">
      <div class="card card-body">
        Vi �r studenter fr�n Lunds Universitet som i tidigt skede p� utbildningen ins�g att det saknades en samlingsplats f�r lunds nationsliv. Vi ville d�rf�r uppr�tta en plattform som underl�ttar f�r b�de nya som l�ngre studerande personer att planera sitt sociala studentliv. 
      </div>
    </div>
  </div>
  <div class="col">
    <div class="collapse multi-collapse" id="multiCollapseExample2">
      <div class="card card-body">
        Vi vill bidra med gr�n systemutveckling med m�let att g�ra v�r verksamhet till ett slutet kretslopp rent organiskt. Vi vill fr�mja studentens sociala liv genom att digitalisera Lunds studentliv utan att kompromissa p� jordens resurser.
      </div>
    </div>
  </div>
</div>
</div>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>