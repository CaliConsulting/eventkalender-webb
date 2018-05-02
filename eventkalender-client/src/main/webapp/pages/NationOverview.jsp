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
				<h5 class="card-title"><a class="text-dark" href="http://www.lundsnation.se/sv/home/">Lunds Nation</a></h5>
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
				<h5 class="card-title"><a class="text-dark" href="http://goteborgsnation.com/">Göteborgs Nation</a></h5>
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
				<h5 class="card-title"><a class="text-dark" href="https://www.malmonation.com/">Malmö Nation</a></h5>
				<p class="card-text">Malmö Nation karaktäriseras av de cirka 90 tjänstemän och 500 funktionärer
				som alla varje termin är med och skapar den speciella stämningen och sammanhållning som vi är
				mycket stolta över på Malmö Nation. Våra tre ledord är: Tradition, Gemenskap &amp; Glädje. Vi har 
				3000 medlemmar i dagsläget vilket gör oss till Lunds näst största nation. Men vi är absolut störst 
				när det kommer till att arrangera fester. Vi har haft uppträdanden från artister såsom: Avicii, Laidback Luke, 
				Kygo, Nause, Joachim Garraud, Sean Kingston och många fler!</p>
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
				<h5 class="card-title"><a class="text-dark" href="https://www.facebook.com/hallandsnation/">Hallands Nation</a></h5>
				<p class="card-text">Hallands Nation är nationen för alla! Här blandas studenter från alla fakulteter i en härlig 
				röra. Vårt hus är alltid fullt av liv och det är lätt att komma in i gemenskapen och lära sig vårt motto; De é 
				kärlek. Hallands Nation har runt 70 förmän som arbetar för att skapa en trevlig atmosfär och för att du som medlem 
				skall få ut så mycket som möjligt av din studietid i Lund. Onsdagspuben är ett perfekt tillfälle att glömma bort 
				skolans stress med dina kursare och utmanas istället av ett klurigt pubquiz eller att bara dyka upp på fredagspuben 
				som ett härligt avslut på veckan.</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
	</div>
	<div class="card-group">
		<div class="card">
			<a href="http://www.blekingska.se/"><img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Blekingska.png"
				alt="Card image cap"></a>
			<div class="card-body">
				<h5 class="card-title"><a class="text-dark" href="http://www.blekingska.se/">Blekingska Nation</a></h5>
				<p class="card-text">Glädje, Gemenskap, Musik är våra ledord. Blekingska är nationen där vi i mer än tjugo år
				 erbjudit en scen där många i dag stora band spelat. Vad sägs om Silvana Imam, Alphaville, Broder Daniel och
				 The Cardigans? Vår legendariska klubb Indigo har erbjudit det bästa inom indie i över två decennier men i några
				 år har vi även drivit electroklubben Heartbeats som spelar fantastisk electronica snarare än mainstream house.</p>
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
				<h5 class="card-title"><a class="text-dark" href="https://krnation.se/">Kristianstad Nation</a></h5>
				<p class="card-text">Kristianstads Nation är din länk mellan fritid och framtid! Vi är en relativt
				 liten nation men med ett garanterat stort hjärta. Vi har ca 1800 inskrivna studenter, och det
				 finns alltid plats för en till. Det är lätt att snabbt komma in i vårt gäng och att få underbara 
				 minnen för livet genom att jobba på någon av våra aktiviteter. Här kan du bland annat dansa i 
				 dimman på Klubb Huset, äta gott till studentpris på både lunch, pub och nattcafé samt se Lunds 
				 bästa nationsspääx.</p>
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
				<h5 class="card-title"><a class="text-dark" href="https://ostgota.nu/">Östgöta Nation</a></h5>
				<p class="card-text">Östgöta Nation har funnits ända sedan 1668 och är din port in i 
				studentlivet. Nationen är en mötesplats för alla Lunds studenter och genomsyras av glädje, 
				engagemang och gemenskap! Vi har ett brett utbud i vår verksamhet och erbjuder allt ifrån 
				matlagning och pub- och klubbverksamhet av hög kvalitet till foto, teknik, idrott och kultur.</p>
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
				<h5 class="card-title"><a class="text-dark" href="https://helsingkrona.se/">Helsingkrona Nation</a></h5>
				<p class="card-text">Helsingkrona Nation karaktäriseras av ett brett utbud av utskott och aktiviteter 
				med en öppen och välkomnande atmosfär med goda möjligheter att utveckla sina egna idéer!Som inskriven 
				i Helsingkrona Nation är du välkommen att engagera dig i våra utskott! Sexmästeriet, Helsingkronaspexet, 
				Idrott, NATU, IT, Redaktionen, Internationella sekretariatet, Foto, Gillestugeriet och Novischeriet.</p>
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
				<h5 class="card-title"><a class="text-dark" href="http://sydskanska.se/sv/">Sydskånska Nation</a></h5>
				<p class="card-text">Nationen där musiken spelar roll! Med en etablerad musiktradition förgyller 
				SSK ditt Lundaliv med det bästa från musikvärlden! Varje helg smäller vi upp dörrarna till klubbar 
				där du kan dansa dig svettig till grymma DJ:s, liveband och feta MC:s. De fyra klubbar som regelbundet 
				huserar på nationen är hiphop- och urbanklubben Svartklubben som kör varannan vecka och Electrified 
				där källaren fylls med vibrerande elektroniska toner.</p>
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
				<h5 class="card-title"><a class="text-dark" href="https://www.facebook.com/Wermlands/">Wermlands Nation</a></h5>
				<p class="card-text">Wermlands erbjuder en plats där du kan känna dig som hemma och snabbt bli en del av 
				gemenskapen. Som Sveriges första KRAV-certifierade studentförening kan vi erbjuda vällagad ekologisk 
				mat och ett brett ölsortiment till studentvänliga priser varje onsdag och lördag. Vi har då våra pubar 
				American pub, Greenway Pub och Pub Aperitivo öppna.</p>
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
				<h5 class="card-title"><a class="text-dark" href="https://www.vgnation.se/">Västgöta Nation</a></h5>
				<p class="card-text">Varmt välkommen till det sprudlande studentlivet i Lund! Livet i Lund är 
				så mycket mer än bara studier så därför är det viktigt att välja en nation där man trivs. 
				Vi på Västgöta Nation är kända för den härliga gemenskapen som kan liknas vid en enda stor familj. 
				Om du vill vara en del av denna familj har du kommit alldeles rätt!</p>
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
				<h5 class="card-title"><a class="text-dark" href="http://kalmarnation.nu/">Kalmar Nation</a></h5>
				<p class="card-text">Kalmar nation är nationen med Lunds högsta mysighetsfaktor. Beläget 
				mitt i stadens bankande studenthjärta blir vår lummiga trädgård under novischperioden din 
				perfekta port in i studielivet. Att Kalmar inte hör till de största nationerna gör oss till 
				ett tight gäng där du lätt hittar vänner för livet!Varje tisdag och fredag håller våra populära 
				pubar öppet. Pub Ölkällaren ger besökaren ett härligt barhäng för den som tycker lill-lördag är för långt borta.</p>
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