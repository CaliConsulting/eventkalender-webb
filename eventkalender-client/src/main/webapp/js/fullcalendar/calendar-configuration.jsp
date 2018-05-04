<%@ page contentType="text/javascript" %>

<%@page import="java.util.List"%>
<%@page import="cali.eventkalender.model.Event"%>

$(document).ready(function() {
	var initialLocaleCode = 'sv';

	// page is now ready, initialize the calendar...
	$('#calendar').fullCalendar({
		header : {
			left : 'prev,next today',
			center : 'title',
			//right : 'month,agendaWeek,agendaDay,listMonth'
			right : 'month'
		},
		locale : initialLocaleCode,
		editable : false,


		events : [ {
		<% 
			List<Event> events = (List<Event>) request.getAttribute("events");
			
			
		%>


		events : [ {
			title : 'All Day Event',
			start : '2018-05-01'
		}, {
			title : 'Long Event',
			start : '2018-05-07',
			end : '2018-05-10'
		}, {
			id : 999,
			title : 'Repeating Event',
			start : '2018-05-09T16:00:00'
		}, {
			id : 999,
			title : 'Repeating Event',
			start : '2018-05-16T16:00:00'
		}, {
			title : 'Conference',
			start : '2018-05-11',
			end : '2018-05-13'
		}, {
			title : 'Meeting',
			start : '2018-05-12T10:30:00',
			end : '2018-05-12T12:30:00'
		}, {
			title : 'Lunch',
			start : '2018-05-12T12:00:00'
		}, {
			title : 'Meeting',
			start : '2018-05-12T14:30:00'
		}, {
			title : 'Happy Hour',
			start : '2018-05-12T17:30:00'
		}, {
			title : 'Dinner',
			start : '2018-05-12T20:00:00'
		}, {
			title : 'Birthday Party',
			start : '2018-05-13T07:00:00'
		}, {
			title : 'Click for Google',
			url : 'http://google.com/',
			start : '2018-05-28'
		} ]
	})
});