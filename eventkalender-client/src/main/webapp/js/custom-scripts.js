// Javascript för att markera om det är invalid
(function() {
	'use strict';
	window.addEventListener('load', function() {
		// Fetch all the forms we want to apply custom Bootstrap validation styles to
		var forms = document.getElementsByClassName('needs-validation');
		// Loop over them and prevent submission
		var validation = Array.prototype.filter.call(forms, function(form) {
			form.addEventListener('submit', function(event) {
				if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
				}
				form.classList.add('was-validated');
			}, false);
		});
	}, false);
})();

jQuery('form[data-toggle="validator"] select').on('change', function(event) {
	event.preventDefault();
	jQuery(this).find('option[disabled]').remove();
});

$(document).ready(function() {
	$("#myInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#myTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
});

$(document).ready(function() {
	if($("#calendar").length > 0) {
		getEvents();
	}
});

function buildCalendar(data) {
	var initialLocaleCode = 'sv';
	
	console.log("startar kalender");
	
	console.log("hej");
	
	$('#calendar').fullCalendar({
		header : {
			left : 'prev,next today',
			center : 'title',
			//right : 'month,agendaWeek,agendaDay,listMonth'
			right : 'month'
		},
		locale : initialLocaleCode,
		editable : false,
		events : data
	})
}

function getEvents() {
	$.post("calendar", function(data, status) {
		alert("Data: " + data);
		buildCalendar(data);
	});
}
