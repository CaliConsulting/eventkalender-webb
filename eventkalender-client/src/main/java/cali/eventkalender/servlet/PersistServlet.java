package cali.eventkalender.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;

@WebServlet("/PersistServlet")
public class PersistServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;
	
    public PersistServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Nation n = new Nation();
		n.setName("TESTNATION");
		
		Event e1 = new Event();
		e1.setName("TESTEVENT");
		e1.setSummary("Detta är en sammanfattning");
		e1.setStartTime(LocalDateTime.now());
		e1.setEndTime(LocalDateTime.now());
		e1.setNation(n);
		
		Set<Event> events = new LinkedHashSet<Event>();
		events.add(e1);
		n.setEvents(events);
		
		facade.addNation(n);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
