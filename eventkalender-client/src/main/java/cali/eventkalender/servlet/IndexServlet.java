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
import cali.eventkalender.model.Person;

@WebServlet("")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@EJB
	private FacadeLocal facade;
	
	public IndexServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Event> events = facade.findAllEvents();
		request.setAttribute("events", events);
		request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		Person p = new Person(firstName, lastName);
		facade.addPerson(p);
		
		System.out.println(firstName + " " + lastName);
		
		doGet(request,response);
	}

}
