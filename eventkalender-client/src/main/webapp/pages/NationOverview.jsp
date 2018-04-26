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
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Lunds.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Lunds Nation</h5>
				<p class="card-text">Den här nationen finns</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Goteborgs.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Göteborgs Nation</h5>
				<p class="card-text">Den här nationen finns</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Malmo.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Malmö Nation</h5>
				<p class="card-text">This card has supporting text below as a
					natural lead-in to additional content.</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Hallands.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Hallands Nation</h5>
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
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Blekingska.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Blekingska Nation</h5>
				<p class="card-text">This is a wider card with supporting text
					below as a natural lead-in to additional content. This content is a
					little bit longer.</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Kristianstad.jpg"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Kristianstad Nation</h5>
				<p class="card-text">This card has supporting text below as a
					natural lead-in to additional content.</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Ostgota.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Östgöta Nation</h5>
				<p class="card-text">Den här nationen finns</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Helsingkrona.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Helsingkrona Nation</h5>
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
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Sydskanska.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Sydskånska Nation</h5>
				<p class="card-text">This is a wider card with supporting text
					below as a natural lead-in to additional content. This content is a
					little bit longer.</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Wermlands.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Wermlands Nation</h5>
				<p class="card-text">This card has supporting text below as a
					natural lead-in to additional content.</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Vastgota.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Västgöta Nation</h5>
				<p class="card-text">Den här nationen finns</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card">
			<img class="card-img-top"
				src="${pageContext.request.contextPath}/img/Kalmar.png"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title">Kalmar Nation</h5>
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