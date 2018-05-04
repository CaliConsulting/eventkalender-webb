package cali.eventkalender.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Event;

@WebServlet("/calendar")
public class CalendarServlet extends HttpServlet {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(CalendarServlet.class);
    
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FacadeLocal facade;

	public CalendarServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    //request.setAttribute("events", events);
		request.getRequestDispatcher("/pages/Calendar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        LOGGER.info("in doPost CalendarServlet");
        
        List<Event> events = facade.findAllEvents();
        
        JsonArray array = new JsonArray();
        for (Event e : events) {
            JsonObject obj = new JsonObject();
            obj.addProperty("title", e.getName());
            obj.addProperty("start", e.getStartTime().toLocalDate().toString());
            obj.addProperty("end", e.getEndTime().toLocalDate().toString());
            array.add(obj);
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.write(array.toString());
        }
        
        LOGGER.info(array.toString());
	}
	
}
