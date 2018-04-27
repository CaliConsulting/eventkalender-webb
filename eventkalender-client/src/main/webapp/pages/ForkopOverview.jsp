<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<header>
		<%@ include file="Header.jsp"%>
	</header>
	<div class="text-center fixed-top"><p>Förköp biljetter till klubben för att säkra din plats och gå före kön!</p>
	</div>
	<div class="card-group">
		<div class="card">
			<a href="http://www.lundsnation.se/sv/home/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Lunds.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="${pageContext.request.contextPath}/forkop"><h5 class="card-title text-dark">Casanova</h5></a>
				<p class="card-text">Malmö Nations nattklubb Casanova!</p>
				<a href="${pageContext.request.contextPath}/forkop" class="btn btn-outline-dark btn-lg">Köp biljetter</a>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<a href="http://goteborgsnation.com/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Goteborgs.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="http://goteborgsnation.com/"><h5 class="card-title text-dark">Kajplats</h5></a>
				<p class="card-text">Göteborg Nations nattklubb Kajplats!</p>
				<a href="${pageContext.request.contextPath}/forkop" class="btn btn-outline-dark btn-lg">Köp biljetter</a>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<a href="https://www.malmonation.com/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Malmo.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="https://www.malmonation.com/"><h5 class="card-title text-dark">T-bar</h5></a>
				<p class="card-text">T-Bar! </p>
				<a href="${pageContext.request.contextPath}/forkop" class="btn btn-outline-dark btn-lg">Köp biljetter</a>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<a href="https://www.facebook.com/hallandsnation/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Hallands.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="https://www.facebook.com/hallandsnation/"><h5 class="card-title text-dark">Hallands Nation</h5></a>
				<p class="card-text">xxx</p>
				<a href="${pageContext.request.contextPath}/forkop" class="btn btn-outline-dark btn-lg">Köp biljetter</a>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
	</div>
	<footer class="footer">
		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>