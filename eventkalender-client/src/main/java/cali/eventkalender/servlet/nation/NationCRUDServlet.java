package cali.eventkalender.servlet.nation;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Nation;

@WebServlet("/nations/crud")
public class NationCRUDServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	
    @EJB
    private FacadeLocal facade;

    public NationCRUDServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Nation> nations = facade.findAllNations();
		request.setAttribute("nations", nations);
		request.getRequestDispatcher("/pages/NationCRUD.jsp").forward(request, response);
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String operation = request.getParameter("operation");
	    if ("addNation".equals(operation)) {
	        String nationName = request.getParameter("nationName");
	        
	        Nation n = new Nation(nationName);
	        facade.addNation(n);
	    } else if ("deleteNation".equals(operation)) {
	        long id = Long.valueOf(request.getParameter("id"));
	        facade.deleteNation(id);
	    }
		doGet(request, response);
	}

}
