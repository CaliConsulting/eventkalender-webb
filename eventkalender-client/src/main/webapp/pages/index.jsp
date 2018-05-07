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
		<div class="welcomeText smokeybackground">
			<h1 class="display-4">Välkommen till Eventkalendern!</h1>
			<h2>Vi hjälper dig planera ditt nationsliv</h2>
		</div>
	</div>
	<main role="main" class="container-fluid">
	<div class="test mt-2 mb-2">
		<div class="card">
			<div class="card-body">
			<h4 class="card-title"><a href="www.studentlund.se" class="text-dark">Gå med i Studentlund.</a></h4>
				<div class="card-deck">
					<div class="card">
						<div class="card-header">
							<h5>Ny som student?</h5>
						</div>
						<div class="card-body">
							<p class="card-text">
								 Då annordnar både nationer och kårer novischveckor, en fartfylldperiod av aktiviteter där du lär dig känna dina
								 nya klasskamrater och nationsmedlemmar. Ett ypperligt tillfälle att utöka din nyvunna umgängeskrets!
							</p>
						</div>
					</div>
					<div class="card">
						<div class="card-header">Header</div>
						<div class="card-body">
							<h5 class="card-title">Card title</h5>
							<p class="card-text">
								This card has supporting text below as a
							</p>
						</div>
					</div>
					<div class="card">
						<div class="card-header"><h5 class="card-title">Studentliv</h5></div>
						<div class="card-body">
							<p class="card-text">
								I Lunds studentliv så annordnar nationerna flertalet aktiviteter såsom idrottskvällar, luncher, sittningar och nattklubbar.
								För att medverka i och ta del av alla dessa måste du som student vara medlem i Studentlund.
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="test1 mt-2 mb-2">
		<div class="card">
			<div class="card-body">
			<h2 class="card-title">
				<a href="https://www.studentlund.se/event/" class="text-dark">Är du redan medlem i Studentlund?</a>
			</h2>
			<p class="card-text">
				Ta då en titt i Eventkalenderns evenemangslista där inköp av förköpsbilljetter är möjligt, eller sök evenemang via Studentlunds egna tjänst för lundastudenterna.
				<img class="card-img mt-2" src="${pageContext.request.contextPath}/img/logo-en.png">
			</p>
			</div>
		</div>
	</div>
	<div class="card bg-dark text-white mt-2 mb-2" style="clear: both;">
		<img class="card-img"
			src="${pageContext.request.contextPath}/img/Ystad.png"
			alt="Card image">
		<div class="card-img-overlay">
			<a href="https://www.facebook.com/hampus.sandell.5"><h5
					class="card-title">Studentnöjen!</h5></a>
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