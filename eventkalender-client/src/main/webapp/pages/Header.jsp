<%@ page import="cali.eventkalender.api.weather.OpenWeatherMapClient" %>
<nav class="navbar navbar-expand-sm navbar-light bg-light">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">
  		<img src="${pageContext.request.contextPath}/img/Cali.png" Width="30" Height="30">
  		Eventkalender
  </a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/">Evenemangslista</a>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Lägg till/Ta bort:
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="${pageContext.request.contextPath}/events/crud">Evenemang</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/nations/crud">Nationer</a>
          <a class="dropdown-item" href="${pageContext.request.contextPath}/persons/crud">Personer</a>
        </div>
      </li>
    </ul>
    <%
		OpenWeatherMapClient c = OpenWeatherMapClient.getInstance();
    %>
    <p><%= c.getTemperature("Lund") %> °C</p>
    <img src="<%= c.getIconLink("Lund") %>">
  </div>
</nav>