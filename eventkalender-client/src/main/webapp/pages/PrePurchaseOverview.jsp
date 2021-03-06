<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div class="prePurchaseImg">
		<div class="prePurchaseText text-center">
			<h1 class="display-4">
				<strong>FÖRKÖP</strong>
			</h1>
			<div class="text-center font-italic">
				<h3>Säkra din plats och gå före kön!</h3>
			</div>
		</div>
	</div>
	<div>
		<h3 class="text-center font-italic text-black bg-light">KÖP
			BILJETTER SOM GER FÖRETRÄDE TILL KLUBBEN</h3>
	</div>
	<main class="container-fluid">
		<div class="card prepurchasespacer">
			<div class="card bg-dark text-white">
				<img class="card-img"
					src="${pageContext.request.contextPath}/img/events/CasanovaRed.png.jpg"
					alt="Card image">
				<div class="card-img-overlay">
					<h5 class="card-title">
						<a class="text-white smokeybackground"
							href="${pageContext.request.contextPath}/prepurchase/info">Casanova</a>
					</h5>
					<p class="card-text smokeybackground">Läs mer.</p>
					<a href="${pageContext.request.contextPath}/prepurchase/info"
						class="btn btn-outline-light">Köp biljetter</a>
				</div>
			</div>
			<div class="card bg-dark text-white">
				<img class="card-img"
					src="${pageContext.request.contextPath}/img/events/kajplats.png"
					alt="Card image">
				<div class="card-img-overlay">
					<h5 class="card-title">
						<a class="text-white smokeybackground"
							href="${pageContext.request.contextPath}/prepurchase/info">Kajplats</a>
					</h5>
					<p class="card-text smokeybackground">Läs mer.</p>
					<a href="${pageContext.request.contextPath}/prepurchase/info"
						class="btn btn-outline-light">Köp biljetter</a>
				</div>
			</div>
			<div class="card bg-dark text-white">
				<img class="card-img"
					src="${pageContext.request.contextPath}/img/events/Skybar1.png"
					alt="Card image">
				<div class="card-img-overlay">
					<h5 class="card-title">
						<a class="text-white smokeybackground"
							href="${pageContext.request.contextPath}/prepurchase/info">Skybar</a>
					</h5>
					<p class="card-text smokeybackground">Läs mer.</p>
					<a href="${pageContext.request.contextPath}/prepurchase/info"
						class="btn btn-outline-light">Köp biljetter</a>
				</div>
			</div>
			<div class="card bg-dark text-white">
				<img class="card-img"
					src="${pageContext.request.contextPath}/img/events/ssk.png"
					alt="Card image">
				<div class="card-img-overlay">
					<h5 class="card-title">
						<a class="text-white smokeybackground"
							href="${pageContext.request.contextPath}/prepurchase/info">Svartklubben</a>
					</h5>
					<p class="card-text smokeybackground">Läs mer.</p>
					<a href="${pageContext.request.contextPath}/prepurchase/info"
						class="btn btn-outline-light">Köp biljetter</a>
				</div>
			</div>
			<div class="card bg-dark text-white">
				<img class="card-img"
					src="${pageContext.request.contextPath}/img/events/rT-bar.png.jpg"
					alt="Card image">
				<div class="card-img-overlay">
					<h5 class="card-title">
						<a class="text-white smokeybackground"
							href="${pageContext.request.contextPath}/prepurchase/info">T-bar</a>
					</h5>
					<p class="card-text smokeybackground">Läs mer.</p>
					<a href="${pageContext.request.contextPath}/prepurchase/info"
						class="btn btn-outline-light">Köp biljetter</a>
				</div>
			</div>
		</div>
	</main>
	<footer class="footer">
		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>