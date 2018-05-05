<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div class="prePurchaseImg">
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
	<h3 class="text-center font-italic text-black">K�P BILJETTER SOM
		GER F�RTR�DE TILL KLUBBEN</h3>
	<div class="card prepurchasespacer">
		<div class="card bg-dark text-white">
			<img class="card-img"
				src="${pageContext.request.contextPath}/img/events/CasanovaRed.png.jpg"
				alt="Card image">
			<div class="card-img-overlay">
				<h5 class="card-title">
					<a class="text-white"
						href="${pageContext.request.contextPath}/prepurchase/info">Casanova</a>
				</h5>
				<p class="card-text">L�s mer.</p>
				<a href="${pageContext.request.contextPath}/prepurchase/info"
					class="btn btn-light">K�p biljetter</a>
			</div>
		</div>
		<div class="card bg-dark text-white">
			<img class="card-img"
				src="${pageContext.request.contextPath}/img/events/kajplats.png"
				alt="Card image">
			<div class="card-img-overlay">
				<h5 class="card-title">
					<a class="text-white"
						href="${pageContext.request.contextPath}/prepurchase/info">Kajplats</a>
				</h5>
				<p class="card-text">L�s mer.</p>
				<a href="${pageContext.request.contextPath}/prepurchase/info"
					class="btn btn-light">K�p biljetter</a>
			</div>
		</div>
		<div class="card bg-dark text-white">
			<img class="card-img"
				src="${pageContext.request.contextPath}/img/events/ssk.png"
				alt="Card image">
			<div class="card-img-overlay">
				<h5 class="card-title">
					<a class="text-white"
						href="${pageContext.request.contextPath}/prepurchase/info">Svartklubben</a>
				</h5>
				<p class="card-text">L�s mer.</p>
				<a href="${pageContext.request.contextPath}/prepurchase/info"
					class="btn btn-light">K�p biljetter</a>
			</div>
		</div>
		<div class="card bg-dark text-white">
			<img class="card-img"
				src="${pageContext.request.contextPath}/img/events/rT-bar.png.jpg"
				alt="Card image">
			<div class="card-img-overlay">
				<h5 class="card-title">
					<a class="text-white"
						href="${pageContext.request.contextPath}/prepurchase/info">T-bar</a>
				</h5>
				<p class="card-text">L�s mer.</p>
				<a href="${pageContext.request.contextPath}/prepurchase/info"
					class="btn btn-light">K�p biljetter</a>
			</div>
		</div>
	</div>
	</main>
	<footer class="footer">
		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>