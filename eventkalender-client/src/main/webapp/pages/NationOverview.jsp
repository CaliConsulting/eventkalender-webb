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
				<h5 class="card-title"><a class="text-dark" href="http://goteborgsnation.com/">G�teborgs Nation</a></h5>
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
				<h5 class="card-title"><a class="text-dark" href="https://www.malmonation.com/">Malm� Nation</a></h5>
				<p class="card-text">Malm� Nation karakt�riseras av de cirka 90 tj�nstem�n och 500 funktion�rer
				som alla varje termin �r med och skapar den speciella st�mningen och sammanh�llning som vi �r
				mycket stolta �ver p� Malm� Nation. V�ra tre ledord �r: Tradition, Gemenskap &amp; Gl�dje. Vi har 
				3000 medlemmar i dagsl�get vilket g�r oss till Lunds n�st st�rsta nation. Men vi �r absolut st�rst 
				n�r det kommer till att arrangera fester. Vi har haft upptr�danden fr�n artister s�som: Avicii, Laidback Luke, 
				Kygo, Nause, Joachim Garraud, Sean Kingston och m�nga fler!</p>
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
				<p class="card-text">Hallands Nation �r nationen f�r alla! H�r blandas studenter fr�n alla fakulteter i en h�rlig 
				r�ra. V�rt hus �r alltid fullt av liv och det �r l�tt att komma in i gemenskapen och l�ra sig v�rt motto; De � 
				k�rlek. Hallands Nation har runt 70 f�rm�n som arbetar f�r att skapa en trevlig atmosf�r och f�r att du som medlem 
				skall f� ut s� mycket som m�jligt av din studietid i Lund. Onsdagspuben �r ett perfekt tillf�lle att gl�mma bort 
				skolans stress med dina kursare och utmanas ist�llet av ett klurigt pubquiz eller att bara dyka upp p� fredagspuben 
				som ett h�rligt avslut p� veckan.</p>
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
				<p class="card-text">Gl�dje, Gemenskap, Musik �r v�ra ledord. Blekingska �r nationen d�r vi i mer �n tjugo �r
				 erbjudit en scen d�r m�nga i dag stora band spelat. Vad s�gs om Silvana Imam, Alphaville, Broder Daniel och
				 The Cardigans? V�r legendariska klubb Indigo har erbjudit det b�sta inom indie i �ver tv� decennier men i n�gra
				 �r har vi �ven drivit electroklubben Heartbeats som spelar fantastisk electronica snarare �n mainstream house.</p>
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
				<p class="card-text">Kristianstads Nation �r din l�nk mellan fritid och framtid! Vi �r en relativt
				 liten nation men med ett garanterat stort hj�rta. Vi har ca 1800 inskrivna studenter, och det
				 finns alltid plats f�r en till. Det �r l�tt att snabbt komma in i v�rt g�ng och att f� underbara 
				 minnen f�r livet genom att jobba p� n�gon av v�ra aktiviteter. H�r kan du bland annat dansa i 
				 dimman p� Klubb Huset, �ta gott till studentpris p� b�de lunch, pub och nattcaf� samt se Lunds 
				 b�sta nationssp��x.</p>
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
				<h5 class="card-title"><a class="text-dark" href="https://ostgota.nu/">�stg�ta Nation</a></h5>
				<p class="card-text">�stg�ta Nation har funnits �nda sedan 1668 och �r din port in i 
				studentlivet. Nationen �r en m�tesplats f�r alla Lunds studenter och genomsyras av gl�dje, 
				engagemang och gemenskap! Vi har ett brett utbud i v�r verksamhet och erbjuder allt ifr�n 
				matlagning och pub- och klubbverksamhet av h�g kvalitet till foto, teknik, idrott och kultur.</p>
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
				<p class="card-text">Helsingkrona Nation karakt�riseras av ett brett utbud av utskott och aktiviteter 
				med en �ppen och v�lkomnande atmosf�r med goda m�jligheter att utveckla sina egna id�er!Som inskriven 
				i Helsingkrona Nation �r du v�lkommen att engagera dig i v�ra utskott! Sexm�steriet, Helsingkronaspexet, 
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
				<h5 class="card-title"><a class="text-dark" href="http://sydskanska.se/sv/">Sydsk�nska Nation</a></h5>
				<p class="card-text">Nationen d�r musiken spelar roll! Med en etablerad musiktradition f�rgyller 
				SSK ditt Lundaliv med det b�sta fr�n musikv�rlden! Varje helg sm�ller vi upp d�rrarna till klubbar 
				d�r du kan dansa dig svettig till grymma DJ:s, liveband och feta MC:s. De fyra klubbar som regelbundet 
				huserar p� nationen �r hiphop- och urbanklubben Svartklubben som k�r varannan vecka och Electrified 
				d�r k�llaren fylls med vibrerande elektroniska toner.</p>
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
				<p class="card-text">Wermlands erbjuder en plats d�r du kan k�nna dig som hemma och snabbt bli en del av 
				gemenskapen. Som Sveriges f�rsta KRAV-certifierade studentf�rening kan vi erbjuda v�llagad ekologisk 
				mat och ett brett �lsortiment till studentv�nliga priser varje onsdag och l�rdag. Vi har d� v�ra pubar 
				American pub, Greenway Pub och Pub Aperitivo �ppna.</p>
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
				<h5 class="card-title"><a class="text-dark" href="https://www.vgnation.se/">V�stg�ta Nation</a></h5>
				<p class="card-text">Varmt v�lkommen till det sprudlande studentlivet i Lund! Livet i Lund �r 
				s� mycket mer �n bara studier s� d�rf�r �r det viktigt att v�lja en nation d�r man trivs. 
				Vi p� V�stg�ta Nation �r k�nda f�r den h�rliga gemenskapen som kan liknas vid en enda stor familj. 
				Om du vill vara en del av denna familj har du kommit alldeles r�tt!</p>
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
				<p class="card-text">Kalmar nation �r nationen med Lunds h�gsta mysighetsfaktor. Bel�get 
				mitt i stadens bankande studenthj�rta blir v�r lummiga tr�dg�rd under novischperioden din 
				perfekta port in i studielivet. Att Kalmar inte h�r till de st�rsta nationerna g�r oss till 
				ett tight g�ng d�r du l�tt hittar v�nner f�r livet!Varje tisdag och fredag h�ller v�ra popul�ra 
				pubar �ppet. Pub �lk�llaren ger bes�karen ett h�rligt barh�ng f�r den som tycker lill-l�rdag �r f�r l�ngt borta.</p>
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