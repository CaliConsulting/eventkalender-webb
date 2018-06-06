package cali.eventkalender.servlet.event;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Event;

@WebServlet("/events/list")
public class EventListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;

	public EventListServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Event> events = facade.findAllEvents();
		request.setAttribute("events", events);
		request.getRequestDispatcher("/pages/EventList.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
