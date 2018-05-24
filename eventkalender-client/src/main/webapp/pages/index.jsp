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
	<main class="container-fluid">
		<div class="indexLeft mt-2 mb-2">
			<div class="card">
				<div class="card-body">
					<h3 class="card-title">
						<a href="https://www.studentlund.se/" class="text-dark">
							Nationerna erbjuder mängder med aktiviteter
						</a>
					</h3>
					<div class="card-deck">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Lunch och brunch</h5>
								<p class="card-text">
									Alla dagar i veckan serverar de olika studentnationerna
									måltider i sina lokaler. Det erbjuds mat med inspiration från alla världens regioner
									och preferenser. Maten tillagas av engagerade studenter.
									<img class="card-img mt-2" src="${pageContext.request.contextPath}/img/kronalunch.png">
								</p>
							</div>
						</div>
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Nattklubb</h5>
								<p class="card-text">
									Med all stress i plugget kan det vara härligt att röra på höfterna
									till lite rytmisk musik med dina vänner. Danssugna är välkomna ut på dansgolven
									mellan onsdag - lördag. Närhelst det passar dina studier såklart.
									<img class="card-img mt-2" src="${pageContext.request.contextPath}/img/nattklubb.png">
								</p>
							</div>
						</div>
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Studentliv</h5>
								<p class="card-text">I Lunds studentliv så anordnar
									nationerna flertalet aktiviteter såsom idrottskvällar, luncher,
									sittningar och nattklubbar. För att medverka i och ta del av
									alla dessa måste du som student vara medlem i Studentlund.
									<img class="card-img mt-2" src="${pageContext.request.contextPath}/img/studentliv.jpg">
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="indexRight mt-2 mb-2">
			<div class="card">
				<div class="card-header">
					<h5 class="card-title">
						<a href="https://www.antagning.se/se/start" class="text-dark">
						I tankarna att börja studera vid Lunds universitet?</a>
					</h5>
				</div>
				<div class="card-body">
					<p class="card-text">
						Lundastudenterna har en otrolig gemenskap som vi på Eventkalendern försöker
						främja i bästa möjliga anda. Ansök till Lunds universitet idag.
						<img class="card-img mt-2" src="${pageContext.request.contextPath}/img/logo-en.png">
					</p>
				</div>
			</div>
		</div>
		<div id="carousel" class="carousel slide mt-2 mb-2"
			data-ride="carousel" style="clear: both;">
			<ol class="carousel-indicators">
				<li data-target="#carouselIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselIndicators" data-slide-to="1"></li>
				<li data-target="#carouselIndicators" data-slide-to="2"></li>
				<li data-target="#carouselIndicators" data-slide-to="3"></li>
				<li data-target="#carouselIndicators" data-slide-to="4"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<a href="${pageContext.request.contextPath}/prepurchase"><img
						class="d-block w-100"
						src="${pageContext.request.contextPath}/img/events/Skybar.png"
						alt="First slide"> </a>
				</div>
				<div class="carousel-item">
					<a href="${pageContext.request.contextPath}/events/list"><img
						class="d-block w-100"
						src="${pageContext.request.contextPath}/img/events/Bedas.png"
						alt="Second slide"></a>
				</div>
				<div class="carousel-item">
					<a href="${pageContext.request.contextPath}/prepurchase"><img
						class="d-block w-100"
						src="${pageContext.request.contextPath}/img/events/CasanovaRed.png.jpg"
						alt="Third slide"></a>
				</div>
				<div class="carousel-item">
					<a href="${pageContext.request.contextPath}/events/list"><img
						class="d-block w-100"
						src="${pageContext.request.contextPath}/img/events/freda.png"
						alt="Fourth slide"></a>
				</div>
				<div class="carousel-item">
					<a href="${pageContext.request.contextPath}/prepurchase"><img
						class="d-block w-100"
						src="${pageContext.request.contextPath}/img/events/kajplats.png"
						alt="Fifth slide"> </a>
				</div>
			</div>
		</div>
		<div class="indexLeft mt-2 mb-2">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">
						<a href="https://www.studentlund.se/" class="text-dark">Gå med
							i Studentlund.</a>
					</h4>
					<div class="card-deck">
						<div class="card">
							<div class="card-header">
								<h5>Ny som student?</h5>
							</div>
							<div class="card-body">
								<p class="card-text">Då anordnar både nationer och kårer
									novischveckor, en fartfylld period av aktiviteter där du lär dig
									känna dina nya klasskamrater och nationsmedlemmar. Ett ypperligt
									tillfälle att utöka din nyvunna umgängeskrets!</p>
							</div>
						</div>
						<div class="card">
							<div class="card-header">
								<h5 class="card-title">Boende</h5>
							</div>
							<div class="card-body">
								<p class="card-text">BoPoolen eller AF Bostäder är två
									excellenta aktörer som kan hjälpa dig hitta boende i Lund.</p>
							</div>
						</div>
						<div class="card">
							<div class="card-header">
								<h5 class="card-title">Studentliv</h5>
							</div>
							<div class="card-body">
								<p class="card-text">I Lunds studentliv så annordnar
									nationerna flertalet aktiviteter såsom idrottskvällar, luncher,
									sittningar och nattklubbar. För att medverka i och ta del av
									alla dessa måste du som student vara medlem i Studentlund.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="indexRight mt-2 mb-2">
			<div class="card" >
				<div class="card-body">
					<h4 class="card-title text-center mt-2">
						<a href="https://www.studentlund.se/event/" class="text-dark">
						Är du redan medlem i Studentlund?</a>
					</h4>
					<p class="card-text">
						Ta då en titt i Eventkalenderns evenemangslista där inköp av
						förköpsbilljetter är möjligt, eller sök evenemang via Studentlunds
						egna tjänst för lundastudenterna.
						<img class="card-img mt-2" src="${pageContext.request.contextPath}/img/Theo.jpg">
					</p>
					<p class="card-text">
						Theo är nöjd, var du det med!
					</p>
				</div>
			</div>
		</div>
	</main>
	<div class="bgImgEnd">
		<div class="goodbyeText smokeybackground">
			<h1 class="display-4">Upplev det själv!</h1>
			<h2>Vi hjälper dig hitta rätt!</h2>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>