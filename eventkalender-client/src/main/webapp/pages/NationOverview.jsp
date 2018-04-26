<%@page import="java.util.List"%>
<%@page import="cali.eventkalender.model.Event"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp"%>
</head>
<body>
	<header>
		<%@ include file="Header.jsp"%>
	</header>
	<div class="card-group">
		<div class="card">
			<a href="http://www.lundsnation.se/sv/home/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Lunds.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="http://www.lundsnation.se/sv/home/"><h5 class="card-title text-dark">Lunds Nation</h5></a>
				<p class="card-text">Varmt välkommen till den bästa tiden i ditt liv! I nationen kan du finna en 
				tillflyktsort när tentaångesten gör sig påmind, CSN har tagit slut eller om du har lite hemlängtan. 
				Här träffar du en härlig blandning av folk från alla olika fakulteter som känner precis som du och 
				vill göra något roligt vid sidan av studierna. Den tid som ligger framför dig kanske verkar oändligt 
				lång, men utan att bli högtravande vill vi säga ta vara på den här tiden och gör det mesta av den.</p>
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
				<a href="http://goteborgsnation.com/"><h5 class="card-title text-dark">Göteborgs Nation</h5></a>
				<p class="card-text">Göteborgs nation kan erbjuda dig en stark gemenskap och en underbar studietid
				 som gör dina år i Lund till de bästa någonsin! Utöver våra löpande verksamheter arrangerar nationen
				 årliga evenemang såsom Gustav II Adolf bal som är Nordens största studentbal, Julfest, Första
				 maj-firande, Räkfest och Novischfester. Göteborgs nation karakteriseras av att vara en nation med
				 fart och glädje i alla sina verksamheter. Vi är den lilla nationen med det stora hjärtat!</p>
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
				<a href="https://www.malmonation.com/"><h5 class="card-title text-dark">Malmö Nation</h5></a>
				<p class="card-text">Malmö Nation karaktäriseras av de cirka 90 tjänstemän och 500 funktionärer
				som alla varje termin är med och skapar den speciella stämningen och sammanhållning som vi är
				mycket stolta över på Malmö Nation. Våra tre ledord är: Tradition, Gemenskap & Glädje. Vi har 3000 medlemmar i dagsläget vilket
				gör oss till Lunds näst största nation. Men vi är absolut störst när det kommer till att arrangera
				fester. Vi har haft uppträdanden från artister såsom: Avicii, Laidback Luke, Kygo, Nause,
				Joachim Garraud, Sean Kingston och många fler!</p>
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
				<p class="card-text">Glädje, Gemenskap, Musik är våra ledord. Blekingska är nationen där vi i mer än tjugo år
				 erbjudit en scen där många i dag stora band spelat. Vad sägs om Silvana Imam, Alphaville, Broder Daniel och
				 The Cardigans? Vår legendariska klubb Indigo har erbjudit det bästa inom indie i över två decennier men i några
				 år har vi även drivit electroklubben Heartbeats som spelar fantastisk electronica snarare än mainstream house..</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
	</div>
	<div class="card-group">
		<div class="card">
			<a href="http://www.blekingska.se//"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Blekingska.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="http://www.blekingska.se//"><h5 class="card-title text-dark">Blekingska Nation</h5></a>
				<p class="card-text">Glädje, Gemenskap, Musik är våra ledord. Blekingska är nationen där vi i mer än tjugo år
				 erbjudit en scen där många i dag stora band spelat. Vad sägs om Silvana Imam, Alphaville, Broder Daniel och
				 The Cardigans? Vår legendariska klubb Indigo har erbjudit det bästa inom indie i över två decennier men i några
				 år har vi även drivit electroklubben Heartbeats som spelar fantastisk electronica snarare än mainstream house..</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<a href="https://krnation.se/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Kristianstad.jpg"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="https://krnation.se/"><h5 class="card-title text-dark">Kristianstad Nation</h5></a>
				<p class="card-text">This card has supporting text below as a
					natural lead-in to additional content.</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<a href="https://ostgota.nu/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Ostgota.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="https://ostgota.nu/"><h5 class="card-title text-dark">Östgöta Nation</h5></a>
				<p class="card-text">Den här nationen finns</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<a href="https://helsingkrona.se/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Helsingkrona.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="https://helsingkrona.se/"><h5 class="card-title text-dark">Helsingkrona Nation</h5></a>
				<p class="card-text">This is a wider card with supporting text
					below as a natural lead-in to additional content. This card has
					even longer content than the first to show that equal height
					action.</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
	</div>
	<div class="card-group">
		<div class="card">
			<a href="http://sydskanska.se/sv/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Sydskanska.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="http://sydskanska.se/sv/"><h5 class="card-title text-dark">Sydskånska Nation</h5></a>
				<p class="card-text">This is a wider card with supporting text
					below as a natural lead-in to additional content. This content is a
					little bit longer.</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<a href="https://www.facebook.com/Wermlands/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Wermlands.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="https://www.facebook.com/Wermlands/"><h5 class="card-title text-dark">Wermlands Nation</h5></a>
				<p class="card-text">This card has supporting text below as a
					natural lead-in to additional content.</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<a href="https://www.vgnation.se/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Vastgota.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="https://www.vgnation.se/"><h5 class="card-title text-dark">Västgöta Nation</h5></a>
				<p class="card-text">Den här nationen finns</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<a href="http://kalmarnation.nu/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Kalmar.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<a href="http://kalmarnation.nu/"><h5 class="card-title text-dark">Kalmar Nation</h5></a>
				<p class="card-text">This is a wider card with supporting text
					below as a natural lead-in to additional content. This card has
					even longer content than the first to show that equal height
					action.</p>
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