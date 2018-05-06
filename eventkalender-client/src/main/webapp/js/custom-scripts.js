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

// kalender
$(document).ready(function() {
	if ($("#calendar").length > 0) {
		$('#calendar').fullCalendar({
			height: parent,
			defaultView: 'month',
			header : {
				left : 'prev,next today',
				center : 'title',
				//right : 'month,agendaWeek,agendaDay,listMonth'
				right : 'month,listWeek,listDay'
			},
			views : {
				listDay : {
					buttonText : 'Dag'
				},
				listWeek : {
					buttonText : 'Vecka'
				}
			},
			locale : 'sv',
			editable : false,
			events : {
				url : 'calendar',
				type : 'POST',
				error : function() {
					alert('there was an error while fetching events!');
				}
			}
		})
	}
});
