package cali.eventkalender.servlet.event;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import cali.eventkalender.utility.JsonUtility;

@WebServlet("/events/crud")
public class EventCRUDServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventCRUDServlet.class);

    private static final long serialVersionUID = 1L;

    @EJB
    private FacadeLocal facade;

    public EventCRUDServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Nation> nations = facade.findAllNations();
        request.setAttribute("nations", nations);
        List<Event> events = facade.findAllEvents();
        request.setAttribute("events", events);
        request.getRequestDispatcher("/pages/EventCRUD.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String postMessage = "";
    	
    	String operation = request.getParameter("operation");
        if ("addEvent".equals(operation)) {
            String name = request.getParameter("name");
            String summary = request.getParameter("summary");

            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime startTime = LocalDateTime.parse(request.getParameter("startTime"), format);
            LocalDateTime endTime = LocalDateTime.parse(request.getParameter("endTime"), format);

            long nationId = Long.valueOf(request.getParameter("nations"));
            Nation nation = facade.findNationById(nationId);

            Event e = new Event(name, summary, startTime, endTime);
            e.setNation(nation);
            facade.addEvent(e);
            
            postMessage = "Du lade till evenemanget " + e.getName();
        } else if ("deleteEvent".equals(operation)) {
            long id = Long.valueOf(request.getParameter("id"));
            Event e = facade.findEventById(id);
            if (e != null) {
                facade.deleteEvent(id);
                postMessage = "Du tog bort evenemanget " + e.getName();
            }
        } else if ("updateEvent".equals(operation)) {
            long id = Long.valueOf(request.getParameter("updateEventList"));
            String name = request.getParameter("updateEventName");
            String summary = request.getParameter("updateEventSummary");

            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDateTime startTime = LocalDateTime.parse(request.getParameter("updateEventStartTime"), format);
            LocalDateTime endTime = LocalDateTime.parse(request.getParameter("updateEventEndTime"), format);

            long nationId = Long.valueOf(request.getParameter("updateEventNations"));
            Nation nation = facade.findNationById(nationId);
            
            Event e = facade.findEventById(id);
            e.setName(name);
            e.setSummary(summary);
            e.setStartTime(startTime);
            e.setEndTime(endTime);
            e.setNation(nation);
            facade.updateEvent(e);
            
            postMessage = "Du uppdaterade evenemanget " + e.getName();
        } else if ("ajaxUpdateEvent".equals(operation)) {
            response.setContentType("application/json;charset=UTF-8");

            long id = Long.valueOf(request.getParameter("id"));

            Event e = facade.findEventById(id);
            try (PrintWriter out = response.getWriter()) {
                out.write(JsonUtility.toJson(e));
            }
            return;
        }
        
        // Sätt attributet endast om vi satt ett meddelande
        if (postMessage != null && !postMessage.isEmpty()) {
            request.setAttribute("postMessage", postMessage);
        }
        
        doGet(request, response);
    }

}
