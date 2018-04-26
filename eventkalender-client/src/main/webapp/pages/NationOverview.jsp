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
				<p class="card-text">Varmt v�lkommen till den b�sta tiden i ditt liv! I nationen kan du finna en 
				tillflyktsort n�r tenta�ngesten g�r sig p�mind, CSN har tagit slut eller om du har lite heml�ngtan. 
				H�r tr�ffar du en h�rlig blandning av folk fr�n alla olika fakulteter som k�nner precis som du och 
				vill g�ra n�got roligt vid sidan av studierna. Den tid som ligger framf�r dig kanske verkar o�ndligt 
				l�ng, men utan att bli h�gtravande vill vi s�ga ta vara p� den h�r tiden och g�r det mesta av den.</p>
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
				<a href="http://goteborgsnation.com/"><h5 class="card-title text-dark">G�teborgs Nation</h5></a>
				<p class="card-text">G�teborgs nation kan erbjuda dig en stark gemenskap och en underbar studietid
				 som g�r dina �r i Lund till de b�sta n�gonsin! Ut�ver v�ra l�pande verksamheter arrangerar nationen
				 �rliga evenemang s�som Gustav II Adolf bal som �r Nordens st�rsta studentbal, Julfest, F�rsta
				 maj-firande, R�kfest och Novischfester. G�teborgs nation karakteriseras av att vara en nation med
				 fart och gl�dje i alla sina verksamheter. Vi �r den lilla nationen med det stora hj�rtat!</p>
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
				<a href="https://www.malmonation.com/"><h5 class="card-title text-dark">Malm� Nation</h5></a>
				<p class="card-text">Malm� Nation karakt�riseras av de cirka 90 tj�nstem�n och 500 funktion�rer
				som alla varje termin �r med och skapar den speciella st�mningen och sammanh�llning som vi �r
				mycket stolta �ver p� Malm� Nation. V�ra tre ledord �r: Tradition, Gemenskap & Gl�dje. Vi har 3000 medlemmar i dagsl�get vilket
				g�r oss till Lunds n�st st�rsta nation. Men vi �r absolut st�rst n�r det kommer till att arrangera
				fester. Vi har haft upptr�danden fr�n artister s�som: Avicii, Laidback Luke, Kygo, Nause,
				Joachim Garraud, Sean Kingston och m�nga fler!</p>
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
				<p class="card-text">Gl�dje, Gemenskap, Musik �r v�ra ledord. Blekingska �r nationen d�r vi i mer �n tjugo �r
				 erbjudit en scen d�r m�nga i dag stora band spelat. Vad s�gs om Silvana Imam, Alphaville, Broder Daniel och
				 The Cardigans? V�r legendariska klubb Indigo har erbjudit det b�sta inom indie i �ver tv� decennier men i n�gra
				 �r har vi �ven drivit electroklubben Heartbeats som spelar fantastisk electronica snarare �n mainstream house..</p>
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
				<p class="card-text">Gl�dje, Gemenskap, Musik �r v�ra ledord. Blekingska �r nationen d�r vi i mer �n tjugo �r
				 erbjudit en scen d�r m�nga i dag stora band spelat. Vad s�gs om Silvana Imam, Alphaville, Broder Daniel och
				 The Cardigans? V�r legendariska klubb Indigo har erbjudit det b�sta inom indie i �ver tv� decennier men i n�gra
				 �r har vi �ven drivit electroklubben Heartbeats som spelar fantastisk electronica snarare �n mainstream house..</p>
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
				<a href="https://ostgota.nu/"><h5 class="card-title text-dark">�stg�ta Nation</h5></a>
				<p class="card-text">Den h�r nationen finns</p>
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
				<a href="http://sydskanska.se/sv/"><h5 class="card-title text-dark">Sydsk�nska Nation</h5></a>
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
				<a href="https://www.vgnation.se/"><h5 class="card-title text-dark">V�stg�ta Nation</h5></a>
				<p class="card-text">Den h�r nationen finns</p>
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