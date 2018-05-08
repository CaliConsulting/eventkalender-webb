package cali.eventkalender.servlet.invitation;

import java.io.IOException;
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

@WebServlet("/invitations")
public class InvitationServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(InvitationServlet.class);

	private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;

	public InvitationServlet() {
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
		request.getRequestDispatcher("/pages/Invitation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if ("InviteToEvents".equals(operation)) {
			String[] persons = request.getParameterValues("persons");
			String[] events = request.getParameterValues("events");
			if (persons != null && events != null) {
				for (String eventId : events) {
					long eId = Long.valueOf(eventId);
					Event e = facade.findEventById(eId);
					for (String personId : persons) {
						long pId = Long.valueOf(personId);
						Person p = facade.findPersonById(pId);
						e.addPerson(p);
					}
					facade.updateEvent(e);
				}
			}
		}
		doGet(request, response);
	}
}
