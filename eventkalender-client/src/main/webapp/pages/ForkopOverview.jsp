<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div class="forkopImg">
		<div class="prePurchaseText text-center">
			<h1>
				<strong>F�RK�P</strong>
			</h1>
			<div class="text-center font-italic">
				<h3>S�kra din plats och g� f�re k�n!</h3>
			</div>
		</div>
	</div>
	<main class="container-fluid">
	<h3 class="text-center font-italic text-black"> K�P BILJETTER SOM GER F�RTR�DE TILL KLUBBEN</h3>
	<div class="card prepurchasespacer">
		<div class="card bg-dark text-white">
			<img class="card-img"
				src="${pageContext.request.contextPath}/img/Casanova.png"
				alt="Card image">
			<div class="card-img-overlay">
				<h5 class="card-title">
					<a class="text-white"href="${pageContext.request.contextPath}/forkop">Casanova</a>
				</h5>
				<a href="${pageContext.request.contextPath}/forkop"
					class="btn btn-outline-lw btn-lg text-center">K�p biljetter</a>
				<p class="card-text">Tandemcykling, Lundakarnevalen, eller
					varf�r inte en b�ttur med trevligt s�llskap?</p>
			</div>
		</div>
		<div class="card bg-dark text-white">
			<img class="card-img"
				src="${pageContext.request.contextPath}/img/kajplats.png"
				alt="Card image">
			<div class="card-img-overlay">
				<h5 class="card-title">
					<a class="text-white" href="${pageContext.request.contextPath}/forkop">Kajplats</a>
				</h5>
				<p class="card-text">Tandemcykling, Lundakarnevalen, eller
					varf�r inte en b�ttur med trevligt s�llskap?</p>
			</div>
		</div>
	</div>
	</main>
	<footer class="footer">
		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>