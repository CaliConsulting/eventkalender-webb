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

$(document).ready(function() {
	$("#submitAddEvent").click(function(e) {
		$("#addEventDateResult").remove();
		//console.log("i jquery addEventForm");
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		//console.log("startTime: " + startTime);
		//console.log("endTime: " + endTime);
		var d1 = new Date(startTime);
		var d2 = new Date(endTime);
		if (d1 >= d2) {
			//console.log("i if");
			$("#startTime").addClass("is-invalid");
			$("#endTime").addClass("is-invalid");
			$('input[name="submitAddEvent"]').closest("form").addClass("was-validated");
			$("#formGroupAddEvent").append('<div id="addEventDateResult" class="alert alert-danger mt-2" role="alert"><strong>Startdatumet måste vara innan slutdatumet</strong></div>');
			return false;
		}
	});
});

// är startdatumet före i tiden än slutdatumet?
$(document).ready(function() {
	$("#submitUpdateEvent").click(function(e) {
		$("#UpdateEventDateResult").remove();
//		console.log("i jquery addEventForm");
		var startTime = $("#updateEventStartTime").val();
		var endTime = $("#updateEventEndTime").val();
//		console.log("startTime: " + startTime);
//		console.log("endTime: " + endTime);
		var d1 = new Date(startTime);
		var d2 = new Date(endTime);
		if (d1 >= d2) {
			//console.log("i if");
			$("#updateEventStartTime").addClass("is-invalid");
			$("#updateEventEndTime").addClass("is-invalid");
			$('input[name="submitUpdateEvent"]').closest("form").addClass("was-validated");
			$("#formGroupUpdateEvent").append('<div id="UpdateEventDateResult" class="alert alert-danger mt-2" role="alert"><strong>Startdatumet måste vara innan slutdatumet</strong></div>');
			return false;
		}
	});
});

jQuery('form[data-toggle="validator"] select').on('change', function(event) {
	event.preventDefault();
	jQuery(this).find('option[disabled]').remove();
});

$(document).ready(function() {
	$("#postMessage").delay(3000).fadeOut(3000, function() {
		$(this).remove();
	});
});

$(document).ready(function() {
	$("#inputNation").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#tableNation tbody tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
});

$(document).ready(function() {
	$("#inputEvent").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#tableEvent tbody tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
});

$(document).ready(function() {
	$("#inputPerson").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#tablePerson tbody tr").filter(function() {
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

//////////////////////////////////
// Funktioner för uppdateringar //
//////////////////////////////////
$(document).ready(function() {
	$("#updateNationList").change(function() {
	    $.post($(location).attr('pathname'), { operation: "ajaxUpdateNation", id: $(this).val() }, function(data) {
	    	console.log("updateNationList");
	    	console.log(data);
	    	
	    	$("#formGroupUpdateNation input").prop("disabled", false);
	    	
	        $("#updateNationName").val(data["name"]);
	    });
	});
});

$(document).ready(function() {
	$("#updatePersonList").change(function() {
	    $.post($(location).attr('pathname'), { operation: "ajaxUpdatePerson", id: $(this).val() }, function(data) {
	    	console.log("updatePersonList");
	    	console.log(data);
	    	
	    	$("#formGroupUpdatePerson input").prop("disabled", false);
	    	
	        $("#updatePersonFirstName").val(data["firstName"]);
	        $("#updatePersonLastName").val(data["lastName"]);
	    });
	});
});

$(document).ready(function() {
	$("#updateEventList").change(function() {
	    $.post($(location).attr('pathname'), { operation: "ajaxUpdateEvent", id: $(this).val() }, function(data) {
	    	console.log("updateEventList");
	    	console.log(data);
	    	
	    	$("#formGroupUpdateEvent input, #formGroupUpdateEvent textarea, #updateEventNations").prop("disabled", false);
	    	
	        $("#updateEventName").val(data["name"]);
	        $("#updateEventSummary").val(data["summary"]);
	        $("#updateEventNations").val(data["nation"]["id"]).change();
	        $("#updateEventStartTime").val(data["startTime"]);
	        $("#updateEventEndTime").val(data["endTime"]);
	    });
	});
});
