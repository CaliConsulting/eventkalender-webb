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
	<main role="main" class="container">
	<div class="test">
		<div class="card-deck">
			<div class="card">
				<img class="card-img-top"
					src="${pageContext.request.contextPath}/img/Lunds.png"
					alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This is a longer card with supporting text
						below as a natural lead-in to additional content. This content is
						a little bit longer.</p>
				</div>
			</div>
			<div class="card">
				<img class="card-img-top" src="..." alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This card has supporting text below as a
						natural lead-in to additional content.</p>
				</div>
			</div>
			<div class="card">
				<img class="card-img-top" src="..." alt="Card image cap">
				<div class="card-body">
					<h5 class="card-title">Card title</h5>
					<p class="card-text">This is a wider card with supporting text
						below as a natural lead-in to additional content. This card has
						even longer content than the first to show that equal height
						action.</p>
				</div>
			</div>
		</div>
	</div>
	<div class="test1">
			<div class="row" style="vertical-align:middle">
				<div class="span12" style="vertical-align:middle">
					<table class="table-condensed table-bordered table-striped" style="vertical-align:middle">
						<thead>
							<tr>
								<th colspan="7"><span class="btn-group"> <a
										class="btn"><i class="icon-chevron-left"></i></a> <a
										class="btn active">February 2012</a> <a class="btn"><i
											class="icon-chevron-right"></i></a>
								</span></th>
							</tr>
							<tr>
								<th>Su</th>
								<th>Mo</th>
								<th>Tu</th>
								<th>We</th>
								<th>Th</th>
								<th>Fr</th>
								<th>Sa</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="muted">29</td>
								<td class="muted">30</td>
								<td class="muted">31</td>
								<td>1</td>
								<td>2</td>
								<td>3</td>
								<td>4</td>
							</tr>
							<tr>
								<td>5</td>
								<td>6</td>
								<td>7</td>
								<td>8</td>
								<td>9</td>
								<td>10</td>
								<td>11</td>
							</tr>
							<tr>
								<td>12</td>
								<td>13</td>
								<td>14</td>
								<td>15</td>
								<td>16</td>
								<td>17</td>
								<td>18</td>
							</tr>
							<tr>
								<td>19</td>
								<td class="btn-primary"><strong>20</strong></td>
								<td>21</td>
								<td>22</td>
								<td>23</td>
								<td>24</td>
								<td>25</td>
							</tr>
							<tr>
								<td>26</td>
								<td>27</td>
								<td>28</td>
								<td>29</td>
								<td class="muted">1</td>
								<td class="muted">2</td>
								<td class="muted">3</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</main>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>