package cali.eventkalender.servlet.nation;

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
import cali.eventkalender.model.Nation;
import cali.eventkalender.utility.JsonUtility;

@WebServlet("/nations/crud")
public class NationCRUDServlet extends HttpServlet {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(NationCRUDServlet.class);
    
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
        String postMessage = "";
    	
    	String operation = request.getParameter("operation");
	    if ("addNation".equals(operation)) {
	        String nationName = request.getParameter("nationName");
	        
	        Nation n = new Nation(nationName);
	        facade.addNation(n);
	        
	        postMessage = "Du lade till nationen " + n.getName();
	    } else if ("deleteNation".equals(operation)) {
	        long id = Long.valueOf(request.getParameter("id"));
	        Nation n = facade.findNationById(id);
	        if (n != null) {
	        	facade.deleteNation(id);
	        	postMessage = "Du tog bort nationen " + n.getName();
	        }
	    } else if ("updateNation".equals(operation)) {
	        long id = Long.valueOf(request.getParameter("updateNationList"));
	        String nationName = request.getParameter("updateNationName");
	        
	        Nation n = facade.findNationById(id);
	        n.setName(nationName);
	        facade.updateNation(n);
	        
	        postMessage = "Du uppdaterade nationen " + n.getName();
	    } else if ("ajaxUpdateNation".equals(operation)) {
	        response.setContentType("application/json;charset=UTF-8");
	        
	        long id = Long.valueOf(request.getParameter("id"));
	        
	        Nation n = facade.findNationById(id);
	        try (PrintWriter out = response.getWriter()) {
	            out.write(JsonUtility.toJson(n));
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
