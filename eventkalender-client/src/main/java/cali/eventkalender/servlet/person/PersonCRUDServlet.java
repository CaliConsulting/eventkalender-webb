package cali.eventkalender.servlet.person;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Person;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/persons/crud")
public class PersonCRUDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private FacadeLocal facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonCRUDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Person> persons = facade.findAllPersons();
		request.setAttribute("persons", persons);
		request.getRequestDispatcher("/pages/PersonCRUD.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
