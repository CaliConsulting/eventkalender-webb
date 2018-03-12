package cali.eventkalender.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cali.eventkalender.facade.FacadeLocal;
import cali.eventkalender.model.Employee;
import cali.eventkalender.model.Nation;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

	@EJB
	private FacadeLocal facade;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Employee e = new Employee();
        e.setName("Mats");
        e.setAddress("Fiskgatan 13");

        PrintWriter out = response.getWriter();
        
        out.write("<html>");
        out.write("<head>");
        out.write("<title>HelloServlet</title>");
        out.write("</head>");
        out.write("<body>");
        
        out.write("<h1>Hello!</h1>");

        out.write("<br />");
        
        out.write(String.format("<p>%s</p><p>%s</p>", e.getName(), e.getAddress()));
        
        Nation n = facade.findByNationId(1);
        
        out.write(String.format("<p>%s</p>", n.getName()));
        
        out.write("</body>");
        out.write("</html>");
    }

}
