package cali.eventkalender.servlet.person;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/persons/crud")
public class PersonCRUDServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	
	@EJB
    private FacadeLocal facade;

    public PersonCRUDServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> persons = facade.findAllPersons();
		request.setAttribute("persons", persons);
		request.getRequestDispatcher("/pages/PersonCRUD.jsp").forward(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String operation = request.getParameter("operation");
	    if ("addPerson".equals(operation)) {
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        	        
	        Person p = new Person(firstName, lastName);
	        facade.addPerson(p);
	    } 
	    else if ("deletePerson".equals(operation)) {
	        long id = Long.valueOf(request.getParameter("id"));
	        facade.deletePerson(id);
	    }
		doGet(request, response);
	}

}
