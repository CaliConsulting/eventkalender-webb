<%
	String message = (String) request.getAttribute("postMessage");
	if (message != null) {
		%>
		<div id="postMessage" class="card text-white bg-success mb-2">
			<div class="card-body">
				<span><%= message %></span>
			</div>
		</div>
		<%
	}
%>