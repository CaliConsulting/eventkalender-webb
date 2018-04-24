package cali.eventkalender.servlet;

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
import cali.eventkalender.model.Event;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.param.Weather;

@WebServlet("")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexServlet.class);
	
	@EJB
	private FacadeLocal facade;
	
	public IndexServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
	    OWM owm = new OWM("e33f7134856ab9fbbe79a544cc23bc39");
	    owm.setUnit(OWM.Unit.METRIC);
	    try {
            CurrentWeather cwd = owm.currentWeatherByCityName("Lund", OWM.Country.SWEDEN);
            double temp = cwd.getMainData().getTemp();
            Weather weather = cwd.getWeatherList().get(0);
            LOGGER.info(weather.getIconLink());
            LOGGER.info(String.valueOf(temp));
            
            request.setAttribute("weatherlink", weather.getIconLink());
            
        } catch (APIException e) {
            // TODO Auto-generated catch block
            LOGGER.info(e.getMessage());
        }
	    
		List<Event> events = facade.findAllEvents();
		request.setAttribute("events", events);
		request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println(firstName + " " + lastName);
		
		doGet(request,response);
	}

}
