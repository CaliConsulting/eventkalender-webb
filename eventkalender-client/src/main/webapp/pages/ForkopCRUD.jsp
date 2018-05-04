<!DOCTYPE html>
<html>
<head>
	<%@ include file="Head.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="Header.jsp"%>
	<!-- /header -->
	<div class="welcomeText text-dark">
	<h2>Fyll i några snabba uppgifter så har du dina biljetter</h2>
	</div>
	<div class="container">
	<form class="needs-validation" novalidate
	action="${pageContext.request.contextPath}/forkop"
	method="POST">
  <div class="form-group">
    <label for="exampleFormControlInput1">Email address</label>
    <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="namn@exempel.com" required />
  </div>
  <div class="form-group">
    <label for="exampleFormControlSelect1">Antal biljetter</label>
    <select class="form-control" id="exampleFormControlSelect1">
      <option>1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
    </select>
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">För- och efternamn</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Förnamn Efternamn" required /></textarea>
  </div>
</form>
<a href="${pageContext.request.contextPath}/forkop" class="btn btn-outline-dark btn-lg float-left">Till betalning</a>
</div>
	<!-- footer -->
	<%@ include file="Footer.jsp"%>
	<!-- /footer -->
</body>
</html>