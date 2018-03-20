package cali.eventkalender.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Nation;

@WebServlet("/RelationServlet")
public class RelationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;

	public RelationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Nation n = facade.findNationById(2);
		
		n.deleteEvent(2);
		n.deleteEvent(5);
		
		facade.updateNation(n);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
