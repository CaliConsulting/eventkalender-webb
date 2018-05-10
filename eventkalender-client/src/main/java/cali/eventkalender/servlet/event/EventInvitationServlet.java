package cali.eventkalender.servlet.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Event;
import cali.eventkalender.model.Person;
import cali.eventkalender.utility.MessageUtility;

@WebServlet("/events/invitations")
public class EventInvitationServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventInvitationServlet.class);

	private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;

	public EventInvitationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Event> events = facade.findAllEvents();
		request.setAttribute("events", events);

		List<Person> persons = facade.findAllPersons();
		request.setAttribute("persons", persons);
		request.getRequestDispatcher("/pages/EventInvitation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String postMessage = "";

		String operation = request.getParameter("operation");
		if ("InviteToEvents".equals(operation)) {
			String[] personsIds = request.getParameterValues("persons");
			String[] eventsIds = request.getParameterValues("events");
			if (personsIds != null && eventsIds != null) {
				List<Person> persons = new ArrayList<>();
				List<Event> events = new ArrayList<>();

				// Hämta alla personer och evenemang på deras respektive id
				Arrays.stream(personsIds).forEach(x -> persons.add(facade.findPersonById(Long.valueOf(x))));
				Arrays.stream(eventsIds).forEach(x -> events.add(facade.findEventById(Long.valueOf(x))));

				for (Event e : events) {
					for (Person p : persons) {
						e.addPerson(p);
					}
					facade.updateEvent(e);
				}
				
				String personsPart = MessageUtility.getPersonsInvitationMessage(persons, 4);
				String eventsPart = MessageUtility.getEventsInvitationMessage(events, 2);
				
				StringBuilder builder = new StringBuilder();
				builder.append("Du bjöd in ");
				builder.append(personsPart);
				builder.append(" till ");
				builder.append(eventsPart);
				postMessage = builder.toString();
			}
		}

		// Sätt attributet endast om vi satt ett meddelande
		if (postMessage != null && !postMessage.equals("")) {
			request.setAttribute("postMessage", postMessage);
		}

		doGet(request, response);
	}
}
