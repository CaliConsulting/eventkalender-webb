package cali.eventkalender.servlet;

import java.io.IOException;

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
import cali.eventkalender.model.Person;

@WebServlet("/RelationServlet")
public class RelationServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(RelationServlet.class);

	private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;

	public RelationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Nation n = facade.findNationById(2);
		//
		// LOGGER.info(n.getEvents().toString());
		//
		// for (Event e : n.getEvents()) {
		// LOGGER.info(e.getNation().getName());
		// }
		//
		// n.deleteEvent(2);
		// n.deleteEvent(5);
		//
		// LOGGER.info(n.getEvents().toString());
		//
		// facade.updateNation(n);

		Person p = facade.findPersonById(2);

		LOGGER.info(p.getEvents().toString());
		
		for (Event e1 : p.getEvents()) {
			LOGGER.info(e1.getName());
		}
		
		p.deleteEvent(1);
		p.deleteEvent(3);
		
		LOGGER.info(p.getEvents().toString());
		
		facade.updatePerson(p);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
