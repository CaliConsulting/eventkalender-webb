<%@page import="java.util.List"%>
<%@page import="cali.eventkalender.model.Event"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!-- /header -->
	<div class="bgImg">
		<div class="welcomeText">
			<h1 class="display-4">Välkommen till Eventkalendern!</h1>
			<h2>Vi hjälper dig planera ditt nationsliv</h2>
		</div>
	</div>
	<main role="main" class="container-fluid">
	<div class="test mt-2 mb-2">
		<div class="card">
			<div class="card-body">
				<div class="card-deck">
					<div class="card">
						<div class="card-header">Usch -10</div>
						<img class="card-img-top"
							src="${pageContext.request.contextPath}/img/Lunds.png"
							alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">Card title</h5>
							<p class="card-text">This is a longer card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Last updated 3 mins ago</small>
						</div>
					</div>
					<div class="card">
						<div class="card-header">Header</div>
						<img class="card-img-top" src="..." alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">Card title</h5>
							<p class="card-text">This card has supporting text below as a
								natural lead-in to additional content.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Last updated 3 mins ago</small>
						</div>
					</div>
					<div class="card">
						<div class="card-header">Header</div>
						<img class="card-img-top" src="..." alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">Card title</h5>
							<p class="card-text">This is a wider card with supporting
								text below as a natural lead-in to additional content. This card
								has even longer content than the first to show that equal height
								action.</p>
						</div>
						<div class="card-footer">
							<small class="text-muted">Last updated 3 mins ago</small>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="test1  mt-2 mb-2">
		<div class="card">
			<div class="card-body">
			</div>
		</div>
	</div>
	<div class="card bg-dark text-white mt-2 mb-2" style="clear: both;">
		<img class="card-img"
			src="${pageContext.request.contextPath}/img/Ystad.png"
			alt="Card image">
		<div class="card-img-overlay">
			<a href="https://www.facebook.com/hampus.sandell.5"><h5 class="card-title">Studentnöjen!</h5></a>
			<p class="card-text">Tandemcykling, Lundakarnevalen, eller varför
				inte en båttur med trevligt sällskap?</p>
		</div>
	</div>
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>