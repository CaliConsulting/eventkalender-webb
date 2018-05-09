package cali.eventkalender.servlet.nation;

import java.io.IOException;
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
import cali.eventkalender.model.Nation;

@WebServlet("/nations/list")
public class NationListServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(NationListServlet.class);

	private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;

	public NationListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        List<Nation> nations = facade.findAllNations();
        request.setAttribute("nations", nations);
		request.getRequestDispatcher("/pages/NationList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
