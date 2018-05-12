package cali.eventkalender.servlet.person;

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

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Person;
import cali.eventkalender.utility.JsonUtility;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/persons/crud")
public class PersonCRUDServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonCRUDServlet.class);
    
    private static final long serialVersionUID = 1L;

    @EJB
    private FacadeLocal facade;

    public PersonCRUDServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Person> persons = facade.findAllPersons();
        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/pages/PersonCRUD.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String postMessage = "";
    	
    	String operation = request.getParameter("operation");
        if ("addPerson".equals(operation)) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");

            Person p = new Person(firstName, lastName);
            facade.addPerson(p);
            
            postMessage = "Du lade till personen " + p.getFirstName() + " " + p.getLastName();
        } else if ("deletePerson".equals(operation)) {
            long id = Long.valueOf(request.getParameter("id"));
            Person p = facade.findPersonById(id);
            if (p != null) {
                facade.deletePerson(id);
                postMessage = "Du tog bort personen " + p.getFirstName() + " " + p.getLastName();
            }
        } else if ("updatePerson".equals(operation)) {
            long id = Long.valueOf(request.getParameter("updatePersonList"));
            String firstName = request.getParameter("updatePersonFirstName");
            String lastName = request.getParameter("updatePersonLastName");
            
            Person p = facade.findPersonById(id);
            p.setFirstName(firstName);
            p.setLastName(lastName);
            facade.updatePerson(p);
            
            postMessage = "Du uppdaterade personen " + p.getFirstName() + " " + p.getLastName();
        } else if ("ajaxUpdatePerson".equals(operation)) {
            response.setContentType("application/json;charset=UTF-8");
            
            long id = Long.valueOf(request.getParameter("id"));

            Person p = facade.findPersonById(id);
            try (PrintWriter out = response.getWriter()) {
                out.write(JsonUtility.toJson(p));
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
