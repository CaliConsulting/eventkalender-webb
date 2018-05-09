<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!-- /header -->
	<h2 class="card-title aboutText mt-3"><u>Välkommen!</u></h2>
	<h4 class="aboutText mt-3">Vi är studenter som brinner för programmering</h4>
	<div class="container-fluid">
	<img class="card-img" style="float: left;"
				src="${pageContext.request.contextPath}/img/AboutImg.png.jpg"
				alt="Card image">
	<div id="accordion">
  <div class="card mt-3" style="width: 68%; float: left; clear: both">
    <div class="card-header text-center" id="headingOne">
      <h5 class="mb-0">
        <button class="btn btn-outline-dark" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
        Syfte
        </button>
        <button class="btn btn-outline-dark" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
    	Ledningsgrupp
     </button>
      </h5>
    </div>
	 <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
      <div class="card-body">
    Hej! Vi är studenter från Lunds Universitet som i tidigt skede under utbildningnen insåg att det saknades en samlingsplats för lunds Nationsliv. Vi ville därför sätta upp en plattform som underlättar för både nya som erfarna studenter att planera sitt sociala studentliv.
		    Vi vill bidra med en grön systemutveckling med målet att göra vår verksamhet till ett slutet kretslopp rent organiskt. Vi vill främja studentens sociala liv genom att digitalisera lunds studentliv utan att kompromissa på jordens resurser.</p></p>
        </div>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
      <div class="card-body">
        Daniel Nilsson <br> Philip Eriksson <br> Hampus Harryson <br> Johan Dyster-Aas.
      </div>
    </div>
  </div>
  </div>
	<div class="card mt-3" style="width: 30%; height: 170px; float: right; clear: both;">
		<div class="card-body">
			<p class="card-text"><strong><u>
				E-mail: Hampa@lol.com <br> <br> Phone: 0738-13 84 57 <br> <br> Address: Östra Vallgatan 36
			</u></strong></p>
		</div>
	</div>
    </div>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>