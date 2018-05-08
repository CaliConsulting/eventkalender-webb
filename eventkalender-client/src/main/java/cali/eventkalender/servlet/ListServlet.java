package cali.eventkalender.servlet;

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
import cali.eventkalender.model.Nation;
import cali.eventkalender.model.Person;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
       
	@EJB
	private FacadeLocal facade;
	
    public ListServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Event> events = facade.findAllEvents();
		request.setAttribute("events", events);
		List<Nation> nations = facade.findAllNations();
	    request.setAttribute("nations", nations);
	    List<Person> persons = facade.findAllPersons();
	    request.setAttribute("persons", persons);
		request.getRequestDispatcher("/pages/List.jsp").forward(request, response);		
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
