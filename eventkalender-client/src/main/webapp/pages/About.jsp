<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!-- /header -->
	<h2 class="card-title aboutText"><u>Om oss</u></h2>
	<div class="container">
	<div class="card" style="width: 65%;">
		<div class="card-body">
		 	<p class="card-text">
		 	Vi är studenter från Lunds Universitet som i tidigt skede under utbildningnen insåg att det saknades en samlingsplats för lunds Nationsliv. Vi ville därför sätta upp en plattform som underlättar för både nya som erfarna studenter att planera sitt sociala studentliv.
		    Vi vill bidra med en grön systemutveckling med målet att göra vår verksamhet till ett slutet kretslopp rent organiskt. Vi vill främja studentens sociala liv genom att digitalisera lunds studentliv utan att kompromissa på jordens resurser.</p></p>
		</div>
	</div>
	<div class="accordion" id="accordion">
  <div class="card" style="width: 65%;">
    <div class="card-header" id="headingOne">
      <h5 class="mb-0">
        <button class="btn btn-outline-dark" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        Syfte
        </button>
        <button class="btn btn-outline-dark" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
    	Ledningsgrupp
     </button>
      </h5>
    </div>

    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
      <div class="card-body">
        </div>
    </div>
  </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
      <div class="card-body">
        Danne, Philipo, Hampa(magic) y Juan.
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