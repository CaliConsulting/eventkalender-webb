package cali.eventkalender.servlet.event;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;

/**
 * Servlet implementation class EventCRUDServlet
 */
@WebServlet("/events/crud")
public class EventCRUDServlet extends HttpServlet {
    
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        request.getRequestDispatcher("/pages/EventCRUD.jsp").forward(request, response);
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String operation = (String) request.getAttribute("operation");
	    if ("addEvent".equals(operation)) {
	        String name = (String) request.getAttribute("name");
	        String summary = (String) request.getAttribute("summary");
	        
	        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	        LocalDateTime startTime = LocalDateTime.parse((String) request.getAttribute("startTime"), format);
	        LocalDateTime endTime = LocalDateTime.parse((String) request.getAttribute("endTime"), format);
	        
	        long nationId = (long) request.getAttribute("nation");
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
