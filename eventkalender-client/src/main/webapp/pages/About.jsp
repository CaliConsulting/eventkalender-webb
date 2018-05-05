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
  <a class="btn btn-outline-dark btn-lg" data-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Vilka vi är</a>
  <button class="btn btn-outline-dark btn-lg" type="button" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2">vårt miljötänk</button>
  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2">Toggle both elements</button>
</p>
<div class="row">
  <div class="col">
    <div class="collapse multi-collapse" id="multiCollapseExample1">
      <div class="card card-body">
        Vi är studenter från Lunds Universitet som i tidigt skede på utbildningen insåg att det saknades en samlingsplats för lunds nationsliv. Vi ville därför upprätta en plattform som underlättar för både nya som längre studerande personer att planera sitt sociala studentliv. 
      </div>
    </div>
  </div>
  <div class="col">
    <div class="collapse multi-collapse" id="multiCollapseExample2">
      <div class="card card-body">
        Vi vill bidra med grön systemutveckling med målet att göra vår verksamhet till ett slutet kretslopp rent organiskt. Vi vill främja studentens sociala liv genom att digitalisera Lunds studentliv utan att kompromissa på jordens resurser.
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