package cali.eventkalender.servlet.event;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
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
import cali.eventkalender.model.Nation;

/**
 * Servlet implementation class EventCRUDServlet
 */
@WebServlet("/events/crud")
public class EventCRUDServlet extends HttpServlet {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EventCRUDServlet.class);
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private FacadeLocal facade;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventCRUDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Nation> nations = facade.findAllNations();
		request.setAttribute("nations", nations);
		List<Event> events = facade.findAllEvents();
		request.setAttribute("events", events);
		request.getRequestDispatcher("/pages/EventCRUD.jsp").forward(request, response);
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String operation = request.getParameter("operation");
	    if ("addEvent".equals(operation)) {
	        String name = request.getParameter("name");
	        String summary = request.getParameter("summary");
	        
	        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	        LocalDateTime startTime = LocalDateTime.parse(request.getParameter("startTime"), format);
	        LocalDateTime endTime = LocalDateTime.parse(request.getParameter("endTime"), format);
	        
	        long nationId = Long.valueOf(request.getParameter("nation"));
	        Nation nation = facade.findNationById(nationId);
	        
	        Event e = new Event(name, summary, startTime, endTime);
	        e.setNation(nation);
	        facade.addEvent(e);
	    } else if ("deleteEvent".equals(operation)) {
	        long id = (long) request.getAttribute("id");
	        facade.deleteEvent(id);
	    }
		doGet(request, response);
	}

}
