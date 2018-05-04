package cali.eventkalender.servlet.event;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Event;
import cali.eventkalender.utility.JsonUtility;

@WebServlet("/events/calendar")
public class EventCalendarServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    private FacadeLocal facade;

    public EventCalendarServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pages/EventCalendar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Event> events = facade.findAllEvents();
        String json = JsonUtility.toCalendarJson(events);

        try (PrintWriter out = response.getWriter()) {
            out.write(json);
        }
    }

}
